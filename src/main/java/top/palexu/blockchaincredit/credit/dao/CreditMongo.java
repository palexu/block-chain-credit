package top.palexu.blockchaincredit.credit.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataContent;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;
import top.palexu.blockchaincredit.credit.model.NaturePerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * 操作mongo的实体类
 */
@Component
public class CreditMongo implements InitializingBean {
    @Autowired
    private Environment environment;

    /**
     * mongo集合名
     */
    public static String COLLECTION_NAME = "";
    /**
     * mongo数据库连接
     */
    private static MongoDatabase mongoDatabase = null;

    /**
     * 初始化mongoDB连接
     *
     * @throws Exception
     */
    @Override
    @SuppressWarnings({"deprecation", "resource"})
    public void afterPropertiesSet() throws Exception {
        String seeds = environment.getProperty("mongodb.data.seeds");
        String user = environment.getProperty("mongodb.data.user");
        String pwd = environment.getProperty("mongodb.data.pwd");
        String replicaSet = environment.getProperty("mongodb.data.replicaSet");
        String dbName = environment.getProperty("mongodb.data.dbName");
        COLLECTION_NAME = environment.getProperty("mongodb.data.collectionName");
        String[] seed = seeds.split(",");

        MongoClient client = null;
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder()
                .connectionsPerHost(800)
                .threadsAllowedToBlockForConnectionMultiplier(50);
        optionsBuilder.connectTimeout(10000).maxWaitTime(25000).socketTimeout(0).socketKeepAlive(true).readPreference(
                ReadPreference.secondary());

        if (StringUtils.isNotEmpty(replicaSet)) {
            optionsBuilder.requiredReplicaSetName(replicaSet);
        }
        MongoClientOptions options = optionsBuilder.build();

        if (seed.length == 1) {
            if (!StringUtils.isEmpty(user) && !StringUtils.isEmpty(pwd)) {
                MongoCredential credential = MongoCredential.createCredential(user, dbName, pwd.toCharArray());
                client = new MongoClient(new ServerAddress(seed[0]), Arrays.asList(credential), options);
            } else {
                client = new MongoClient(new ServerAddress(seed[0]), options);
            }
        } else {
            List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
            for (String str : seed) {
                String[] s = str.split(":");
                serverAddresses.add(new ServerAddress(s[0], Integer.valueOf(s[1])));
            }
            if (!StringUtils.isEmpty(user) && !StringUtils.isEmpty(pwd)) {
                MongoCredential credential = MongoCredential.createCredential(user, dbName, pwd.toCharArray());
                client = new MongoClient(serverAddresses, Arrays.asList(credential), options);
            } else {
                client = new MongoClient(serverAddresses, options);
            }
        }
        mongoDatabase = client.getDatabase(dbName);
    }

    /**
     * 插入content,如存在则替换
     * 不管naturePerson
     * <p>
     * todo 如何高效增改
     *
     * @param data
     * @return
     */
    public boolean upsertCreditContent(CreditData data) {
        assert data.getDatas().size() != 0;

        CreditData old = this.selectOne(data.getProvider(), data.getSubject(), data.getBizType());
        if (null == old) {
            Document document = new Document();

            document.put("provider", data.getProvider());
            document.put("subject", data.getSubject());
            document.put("bizType", data.getBizType());

            document.put("naturePerson", JSON.toJSONString(data.getNaturePerson()));

            data.getLatestContent().setVersion(0L);
            document.put("datas", JSON.toJSONString(data.getDatas()));

            mongoDatabase.getCollection(COLLECTION_NAME).insertOne(document);
        } else {
            //set version
            Long oldVersion = old.getDatas().size() == 0 ? -1 : old.getLatestContent().getVersion();
            data.getLatestContent().setVersion(oldVersion + 1);

            old.addContent(data.getLatestContent());

            return this.update(data.getProvider(), data.getSubject(), data.getBizType(), data.getNaturePerson(),
                        old.getDatas());
        }
        return true;
    }

    /**
     * 查询
     *
     * @param provider
     * @param subject
     * @param bizType
     * @return
     */
    public CreditData selectOne(String provider, String subject, String bizType) {
        Document document = mongoDatabase.getCollection(COLLECTION_NAME).find(
                and(eq("provider", provider), eq("subject", subject), eq("bizType", bizType))).first();

        if (document == null) {
            return null;
        }

        CreditData data = new CreditData();
        data.setProvider(document.getString("provider"));
        data.setSubject(document.getString("subject"));
        data.setBizType(document.getString("bizType"));
        data.setDatas(JSON.parseObject(document.getString("datas"), new TypeReference<List<CreditDataContent>>() {}));
        data.setNaturePerson(JSON.parseObject(document.getString("naturePerson"), NaturePerson.class));

        return data;
    }

    /**
     * 查询
     *
     * @param subject
     * @param bizType
     * @return
     */
    public List<CreditData> selectCreditData(String subject, String bizType) {
        FindIterable<Document> documentFindIterable = mongoDatabase.getCollection(COLLECTION_NAME).find(
                and(eq("subject", subject), eq("bizType", bizType)));

        List<CreditData> creditDatas = new ArrayList<>();
        for (Document doc : documentFindIterable) {
            creditDatas.add(JSON.parseObject(doc.toJson(), CreditData.class));
        }

        return creditDatas;
    }

    /**
     * 查询subject主体的所有相关信用数据
     *
     * @param subject
     * @return
     */
    public List<CreditDataRecord> selectRecordBySubject(String subject) {
        FindIterable<Document> documentFindIterable = mongoDatabase.getCollection(COLLECTION_NAME).find(
                eq("subject", subject));

        List<CreditDataRecord> creditDatas = new ArrayList<>();
        for (Document doc : documentFindIterable) {
            creditDatas.add(JSON.parseObject(doc.toJson(), CreditDataRecord.class));
        }

        return creditDatas;
    }

    /**
     * 查询subject主体的所有相关信用数据
     *
     * @param subject
     * @return
     */
    public List<CreditDataRecord> selectRecordBySubjectBizType(String subject, String bizType) {
        FindIterable<Document> documentFindIterable = mongoDatabase.getCollection(COLLECTION_NAME).find(
                and(eq("subject", subject), eq("bizType", bizType)));

        List<CreditDataRecord> creditDatas = new ArrayList<>();
        for (Document doc : documentFindIterable) {
            creditDatas.add(JSON.parseObject(doc.toJson(), CreditDataRecord.class));
        }

        return creditDatas;
    }


    /**
     * 根据 provider subject bizType 来更新 datadata，print
     *
     * @param provider
     * @param subject
     * @param bizType
     * @param datas
     * @return
     */
    public boolean update(String provider, String subject, String bizType, NaturePerson naturePerson,
                          List<CreditDataContent> datas) {
        Document oldDocument = new Document();
        oldDocument.put("provider", provider);
        oldDocument.put("subject", subject);
        oldDocument.put("bizType", bizType);

        Document newDocument = new Document();
        newDocument.putAll(oldDocument);
        newDocument.put("naturePerson", JSON.toJSONString(naturePerson));
        newDocument.put("datas", JSON.toJSONString(datas));

        return mongoDatabase.getCollection(COLLECTION_NAME).replaceOne(oldDocument, newDocument).getModifiedCount()>0;
    }


    public boolean delete(String provider, String subject, String bizType) {
        DeleteResult result = mongoDatabase.getCollection(COLLECTION_NAME).deleteMany(
                and(eq("provider", provider), eq("subject", subject), eq("bizType", bizType)));

        return result.getDeletedCount() > 0;
    }

    //    public boolean delete(String print) {
    //        DeleteResult result = mongoDatabase.getCollection(COLLECTION_NAME).deleteOne(eq("print", print));
    //
    //        return result.getDeletedCount() > 0;
    //    }

}
