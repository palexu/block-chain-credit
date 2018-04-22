package top.palexu.blockchaincredit.credit.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.credit.TestBase;
import top.palexu.blockchaincredit.credit.model.CreditData;


public class CreditMongoTest extends TestBase{

    @Autowired
    CreditMongo creditMongo;

    public void insert() throws Exception {
        CreditData data = new CreditData();
        data.setData("hello");
        data.setBizType("bank");
        data.setPrint("print");
        data.setProvider("test");
        data.setSubject("wang");

        creditMongo.insert(data);
    }

    public void select() throws Exception {
        CreditData data = creditMongo.selectOneByPrint("print");
        Assert.assertNotNull(data);
    }

    public void updateOne() throws Exception {
        Assert.assertTrue(creditMongo.update("test", "wang", "bank", "hhhhhh", "pppp"));
    }

    public void deleteOne() throws Exception {
        Assert.assertTrue(creditMongo.delete("test", "wang", "bank"));
    }

    @Test
    public void mainTest() throws Exception {
        this.insert();
        this.select();
        this.updateOne();
        this.deleteOne();
    }


}