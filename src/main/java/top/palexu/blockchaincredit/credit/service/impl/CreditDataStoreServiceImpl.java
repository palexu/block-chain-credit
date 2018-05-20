package top.palexu.blockchaincredit.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.dao.CreditMongo;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataContent;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;
import top.palexu.blockchaincredit.credit.model.CreditDataRow;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.credit.util.PrintUtil;

import java.util.List;
import java.util.Map;

/**
 * todo 在这一层做缓存，
 * 缓存由自己实现，模仿guava，并定义几个指标，进行量化
 * 缓存放在外部模块吧
 */
@Component
public class CreditDataStoreServiceImpl implements CreditDataStoreService {

    @Autowired
    CreditMongo creditMongo;

    /**
     * 增量添加用户数据
     *
     * @param creditData
     * @return
     */
    @Override
    public boolean insertCreditDataContent(CreditData creditData) {
        //只接受最新的那一条
        assert creditData.getDatas().size() == 1;

        //1.取出老数据并融合
        CreditData old = creditMongo.selectOne(creditData.getProvider(), creditData.getSubject(),
                                               creditData.getBizType());
        if (null != old && old.getLatestContent() != null) {
            CreditDataContent content = old.getLatestContent();
            Map<String, List<CreditDataRow>> newRows = creditData.getLatestContent().getData();
            for (String k : newRows.keySet()) {
                newRows.get(k).addAll(content.getData().get(k));
            }
        }

        //2.计算指纹
        String print = PrintUtil.getDataPrint(creditData.getProvider(), creditData.getSubject(),
                                              creditData.getBizType(),
                                              creditData.getLatestContent().getData().toString());
        creditData.getLatestContent().setPrint(print);

        //todo 3.保存记录落区块链  需判断出是插入删除之类的属性
        boolean saveToBlockSuccess = true;

        //4.落库
        if (saveToBlockSuccess) {
            return creditMongo.upsertCreditContent(creditData);
        } else {
            return false;
        }
    }

    @Override
    public CreditData selectCreditData(CreditData creditData) {
        //todo 查询记录落block
        return creditMongo.selectOne(creditData.getProvider(), creditData.getSubject(), creditData.getBizType());
    }

    @Override
    public CreditData selectCreditData(String provider, String subject, String bizType) {
        CreditData creditData = new CreditData();
        creditData.setProvider(provider);
        creditData.setSubject(subject);
        creditData.setBizType(bizType);
        return this.selectCreditData(creditData);
    }

    @Override
    public List<CreditData> selectCreditData(String subject, String bizType) {
        return creditMongo.selectCreditData(subject, bizType);
    }

    @Override
    public List<CreditDataRecord> selectAllRecordBySubject(String subject) {
        return creditMongo.selectRecordBySubject(subject);
    }

    @Override
    public List<CreditDataRecord> selectAllRecordBySubjectBizType(String subject, String bizType) {
        return creditMongo.selectRecordBySubjectBizType(subject, bizType);
    }

    @Override
    public boolean deleteCreditData(CreditData creditData) {
        boolean result = false;

        //todo 删除记录落block
        //...


        result = creditMongo.delete(creditData.getProvider(), creditData.getSubject(), creditData.getBizType());


        return result;
    }
}
