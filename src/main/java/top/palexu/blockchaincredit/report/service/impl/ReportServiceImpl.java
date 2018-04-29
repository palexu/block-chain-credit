package top.palexu.blockchaincredit.report.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.CalculateHelper;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.ReportEngine;
import top.palexu.blockchaincredit.report.engine.script.Factor;
import top.palexu.blockchaincredit.report.service.FactorService;
import top.palexu.blockchaincredit.report.service.ReportService;

import java.util.Map;

/**
 * @author xjy
 */
@Component
@Slf4j
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
        assert Strings.isNotBlank(context.getBizType().getValue());

        //1.设置计算所需的工具
        context.setCalculateHelper(new CalculateHelper());

        Long templateId = factorService.findTemplateIdByBiztype(context.getBizType().getValue());
        if (templateId == null) {
            log.error("biztype={} 所关联的模板为空", context.getBizType());
            return null;
        }

        context.getCalculateHelper().setFactorDos(factorService.findFactorByTemplateId(templateId));
        context.getCalculateHelper().setScriptDos(factorService.findScriptByTemplateId(templateId));

        //2.计算
        engine.calculate(context);

        //3.返回结果
        return context.getFactorMap();
    }
}
