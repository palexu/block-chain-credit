package top.palexu.blockchaincredit.credit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;
import top.palexu.blockchaincredit.credit.dao.CreditMongo;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.util.DataMockUtil;


public class CreditMongoTest extends TestBase {

    @Autowired
    CreditMongo creditMongo;

    public void insert() throws Exception {
        CreditData data = new CreditData();
        data.setData("hello");
        data.setBizType("bank");
        data.setPrint("print");
        data.setProvider("test");
        data.setSubject("wang");

        creditMongo.upsert(data);
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

    @Test
    public void selectRecordBySubject() throws Exception {
        Assert.assertTrue(creditMongo.selectRecordBySubject("TEST01").size() > 0);
    }

    @Test
    public void selectOne() {
        Assert.assertTrue(null == creditMongo.selectOne(DataMockUtil.PROVIDER, DataMockUtil.SUBJECT,
                                                        "NONE_EXIST_BIZTYPE_9fh783gfbksf124e1safw4t"));
    }

}