package top.palexu.blockchaincredit.report.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;
import top.palexu.blockchaincredit.report.model.FactorDo;

public class FactorDoMapperTest extends TestBase {
    @Autowired
    FactorDoMapper factorDoMapper;

    public void deleteByPrimaryKey() {
        Assert.assertTrue(factorDoMapper.deleteByPrimaryKey(1L) > 0);
    }

    public void insert() {
        FactorDo factorDo = new FactorDo();
        factorDo.setName("h");
        factorDo.setScriptId(0L);
        factorDo.setDesc("test");
        factorDoMapper.insert(factorDo);
    }

    public void selectByScriptId() {
        Assert.assertNotNull(factorDoMapper.selectByScriptId(0L));
    }

    @Test
    public void main() {
        this.insert();
        this.selectByScriptId();
        this.deleteByPrimaryKey();
    }

}