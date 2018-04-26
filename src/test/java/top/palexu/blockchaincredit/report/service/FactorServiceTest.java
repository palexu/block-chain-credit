package top.palexu.blockchaincredit.report.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;

public class FactorServiceTest extends TestBase {

    @Autowired
    FactorService factorService;

    @Test
    public void findByTemplate() throws Exception {
        Assert.assertTrue(factorService.findFactorByTemplateId(0L).size() > 0);
    }

    @Test
    public void findScriptByTemplateId() throws Exception {
        Assert.assertTrue(factorService.findScriptByTemplateId(0L).size() > 0);
    }

}