package top.palexu.blockchaincredit.report.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;

public class FactorTemplateRelationMapperTest extends TestBase{
    @Autowired
    FactorTemplateRelationMapper mapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }


    @Test
    public void insert() throws Exception {

    }

    @Test
    public void findFactorIdByTemplateId() throws Exception {
        Assert.assertTrue(mapper.findFactorIdByTemplateId(0L).size() > 0);
    }

}