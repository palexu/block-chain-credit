package top.palexu.blockchaincredit.report.service;

import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.Factor;

import java.util.Map;

/**
 * @author xjy
 */
public interface ReportService {
    /**
     * 信用卡报告
     * 需要 provider、subject、biztype 三个参数
     *
     * @param context
     * @return
     */
    Map<String,Factor> creditCardReport(ReportContext context);
}
