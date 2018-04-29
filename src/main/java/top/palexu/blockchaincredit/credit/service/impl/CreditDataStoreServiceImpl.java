package top.palexu.blockchaincredit.credit.service.impl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.dao.CreditMongo;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.credit.util.PrintUtil;

import java.util.List;

/**
 * todo 在这一层做缓存，
 * 缓存由自己实现，模仿guava，并定义几个指标，进行量化
 * 缓存放在外部模块吧
 */
@Component
public class CreditDataStoreServiceImpl implements CreditDataStoreService {

    @Autowired
    CreditMongo creditMongo;

    @Override
    public boolean insertCreditData(CreditData creditData) {
        //计算指纹
        String print = PrintUtil.getDataPrint(creditData.getProvider(), creditData.getSubject(),
                                              creditData.getBizType(), creditData.getData());
        creditData.setPrint(print);

        //todo 保存记录落区块链
        boolean saveToBlockSuccess = true;

        //落数据库
        if (saveToBlockSuccess) {
            return creditMongo.upsert(creditData);
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
    public List<CreditDataRecord> selectAllRecordBySubject(String subject) {
        return creditMongo.selectRecordBySubject(subject);
    }

    @Override
    public boolean updateCreditData(CreditData creditData) {
        //todo 修改记录落block
        return false;
    }

    @Override
    public boolean deleteCreditData(CreditData creditData) {
        boolean result = false;

        //todo 删除记录落block
        //...

        //删除库数据
        if (Strings.isNotBlank(creditData.getPrint())) {
            result = creditMongo.delete(creditData.getPrint());
        } else {
            result = creditMongo.delete(creditData.getProvider(), creditData.getSubject(), creditData.getBizType());
        }

        return result;
    }
}
