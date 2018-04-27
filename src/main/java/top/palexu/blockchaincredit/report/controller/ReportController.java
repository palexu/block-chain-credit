package top.palexu.blockchaincredit.report.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.facade.ReportService;

@RestController
@RequestMapping(value = "/report/search")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/creditCard/{provider}/{subject}/{bizType}")
    public String creditCardReport(@PathVariable("provider") String provider, @PathVariable("subject") String subject,
                                   @PathVariable("bizType") String bizType) {
        ReportContext context = new ReportContext(subject, provider, bizType);
        return JSON.toJSONString(reportService.creditCardReport(context));
    }
}
