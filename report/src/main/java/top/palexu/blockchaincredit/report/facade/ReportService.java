package top.palexu.blockchaincredit.report.facade;

import top.palexu.blockchaincredit.report.ReportContext;

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
    String creditCardReport(ReportContext context);
}
