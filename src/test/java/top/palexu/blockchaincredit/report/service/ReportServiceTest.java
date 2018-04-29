package top.palexu.blockchaincredit.report.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;
import top.palexu.blockchaincredit.credit.util.DataMockUtil;
import top.palexu.blockchaincredit.report.ReportContext;


public class ReportServiceTest extends TestBase {

    @Autowired
    ReportService reportService;

    @Autowired
    DataMockUtil util;

    @Before
    public void setUp() {
        util.mockDataIntoDb(DataMockUtil.BIZ_TYPE);
    }

//    @After
    public void tearDown() {
        util.cleanUpMockDataFromDb(DataMockUtil.BIZ_TYPE);
    }

    @Test
    public void creditCardReport() throws Exception {

        ReportContext context = new ReportContext();

        context.setProvider(DataMockUtil.PROVIDER);
        context.setSubject(DataMockUtil.SUBJECT);
        context.setBizType(DataMockUtil.BIZ_TYPE);

        Assert.assertTrue(null != reportService.creditCardReport(context));
    }

}