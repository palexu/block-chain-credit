package top.palexu.blockchaincredit.credit.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.credit.TestBase;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.credit.util.DataMockUtil;

public class CreditDataStoreServiceImplTest extends TestBase {
    DataMockUtil util = new DataMockUtil();

    @Autowired
    CreditDataStoreService creditDataStoreService;

    @Test
    public void test() {

        CreditData data = util.plainCreditData();
        Assert.assertTrue(creditDataStoreService.insertCreditData(data));
        Assert.assertTrue(creditDataStoreService.deleteCreditData(data));
    }

}