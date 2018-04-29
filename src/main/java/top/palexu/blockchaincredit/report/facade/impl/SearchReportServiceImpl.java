package top.palexu.blockchaincredit.report.facade.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.Factor;
import top.palexu.blockchaincredit.report.facade.Report;
import top.palexu.blockchaincredit.report.facade.SearchReportJson;
import top.palexu.blockchaincredit.report.facade.SearchReportService;
import top.palexu.blockchaincredit.report.service.ReportService;

import java.util.Date;
import java.util.Map;

@Service
public class SearchReportServiceImpl implements SearchReportService {
    @Autowired
    ReportService reportService;

    /**
     * @param subject
     * @return
     */
    @Override
    public String search(String subject) {
        SearchReportJson searchReportJson = new SearchReportJson();

        //用idcard找到所有相关数据


        //按照bizType不同，选择不同报告生成器进行计算  todo 需要bizType-data-service的关联关系

        //组合所有的报告并返回报告


        ReportContext context = new ReportContext(subject, "DATAHUB", "creditCard");

        Map<String, Factor> factorMap = reportService.creditCardReport(context);
        Report report = new Report();
        report.setReportName("信用卡报告");
        report.setDesc("信用卡报告-DATAHUB");
        report.getFactors().addAll(factorMap.values());
        report.setGmtCreated(new Date());

        searchReportJson.getReports().add(report);
        searchReportJson.getReports().add(report);
        searchReportJson.getReports().add(report);

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(searchReportJson, SerializerFeature.WriteDateUseDateFormat,
                                 SerializerFeature.DisableCircularReferenceDetect);
    }
}
