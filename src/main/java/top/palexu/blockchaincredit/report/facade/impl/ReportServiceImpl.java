package top.palexu.blockchaincredit.report.facade.impl;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.ReportEngine;
import top.palexu.blockchaincredit.report.facade.ReportService;

/**
 * @author xjy
 */
@Component
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportEngine engine;

    /**
     * 信用卡报告
     *
     * @return
     */
    @Override
    public String creditCardReport(ReportContext context) {
        assert Strings.isNotBlank(context.getProvider());
        assert Strings.isNotBlank(context.getSubject());
        assert Strings.isNotBlank(context.getBizType().value);

        engine.calculate(context);

        //toJSONString
        if (null != context.getReportResult()) {
            return JSON.toJSONString(context.getReportResult());
        } else {
            return null;
        }
    }
}
