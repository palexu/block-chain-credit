package top.palexu.blockchaincredit.credit.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.credit.util.DataMockUtil;

public class CreditDataStoreServiceImplTest extends TestBase {
    DataMockUtil util = new DataMockUtil();

    @Autowired
    CreditDataStoreService creditDataStoreService;

    @Test
    public void test() {

        //todo 测试多次插入
//        DataMockUtil.SUBJECT = "top.palexu.blockchaincredit.credit.service.impl.CreditDataStoreServiceImplTest.test";
        DataMockUtil.PROVIDER="TEST_NLFOUWEF";
        CreditData data = DataMockUtil.mockData(BizTypeEnum.creditCard);
        Assert.assertTrue(creditDataStoreService.insertCreditDataContent(data));
        data = DataMockUtil.mockData(BizTypeEnum.creditCard);
        Assert.assertTrue(creditDataStoreService.insertCreditDataContent(data));
        data = DataMockUtil.mockData(BizTypeEnum.creditCard);
        Assert.assertTrue(creditDataStoreService.insertCreditDataContent(data));
//        Assert.assertTrue(creditDataStoreService.deleteCreditData(data));
    }

}