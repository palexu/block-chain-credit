package top.palexu.blockchaincredit.report.facade.impl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.CalculateHelper;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.ReportEngine;
import top.palexu.blockchaincredit.report.engine.script.Factor;
import top.palexu.blockchaincredit.report.facade.ReportService;
import top.palexu.blockchaincredit.report.service.FactorService;

import java.util.Map;

/**
 * @author xjy
 */
@Component
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportEngine engine;

    @Autowired
    FactorService factorService;

    /**
     * 信用卡报告
     *
     * @return
     */
    @Override
    public Map<String, Factor> creditCardReport(ReportContext context) {
        assert Strings.isNotBlank(context.getProvider());
        assert Strings.isNotBlank(context.getSubject());
        assert Strings.isNotBlank(context.getBizType().value);

        //1.设置计算所需的工具
        context.setCalculateHelper(new CalculateHelper());
        context.getCalculateHelper().setFactorDos(factorService.findFactorByTemplateId(0L));
        context.getCalculateHelper().setScriptDos(factorService.findScriptByTemplateId(0L));

        //2.计算
        engine.calculate(context);

        //3.返回结果
        if (null != context.getFactorMap()) {
            return context.getFactorMap();
        } else {
            return null;
        }
    }
}
