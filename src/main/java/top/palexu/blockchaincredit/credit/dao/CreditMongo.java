package top.palexu.blockchaincredit.credit.dao;

import com.alibaba.fastjson.JSON;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.model.CreditData;

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
     * 插入数据
     *
     * @param data
     * @return
     */
    public boolean insert(CreditData data) {
        Document document = new Document();
        document.put("provider", data.getProvider());
        document.put("subject", data.getSubject());
        document.put("bizType", data.getBizType());
        document.put("data", data.getData());
        document.put("print", data.getPrint());

        mongoDatabase.getCollection(COLLECTION_NAME).insertOne(document);
        return true;
    }

    /**
     * 查询
     *
     * @param print 指纹
     * @return
     */
    public CreditData selectOneByPrint(String print) {
        Document document = mongoDatabase.getCollection(COLLECTION_NAME).find(eq("print", print)).first();
        return JSON.parseObject(document.toJson(), CreditData.class);
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
        return JSON.parseObject(document.toJson(), CreditData.class);
    }

    /**
     * 根据 provider subject bizType 来更新 datadata，print
     *
     * @param provider
     * @param subject
     * @param bizType
     * @param data
     * @param print
     * @return
     */
    public boolean update(String provider, String subject, String bizType, String data, String print) {
        Document oldDocument = new Document();
        oldDocument.put("provider",provider);
        oldDocument.put("subject",subject);
        oldDocument.put("bizType",bizType);

        Document newDocument = new Document();
        newDocument.putAll(oldDocument);
        newDocument.put("data", data);
        newDocument.put("print", print);

        return null != mongoDatabase.getCollection(COLLECTION_NAME).replaceOne(oldDocument, newDocument);
    }


    public boolean delete(String provider, String subject, String bizType) {
        DeleteResult result = mongoDatabase.getCollection(COLLECTION_NAME).deleteMany(
                and(eq("provider", provider), eq("subject", subject), eq("bizType", bizType)));

        return result.getDeletedCount() > 0;
    }

    public boolean delete(String print) {
        DeleteResult result = mongoDatabase.getCollection(COLLECTION_NAME).deleteOne(eq("print", print));

        return result.getDeletedCount() > 0;
    }

}
