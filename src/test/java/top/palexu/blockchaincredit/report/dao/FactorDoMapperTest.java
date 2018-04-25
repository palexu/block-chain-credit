package top.palexu.blockchaincredit.report.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;
import top.palexu.blockchaincredit.report.model.FactorDo;

public class FactorDoMapperTest extends TestBase {
    @Autowired
    FactorDoMapper factorDoMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        FactorDo factorDo = new FactorDo();
        factorDo.setId(0L);
        factorDo.setName("h");
        factorDo.setDesc("test");
        factorDoMapper.insert(factorDo);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}