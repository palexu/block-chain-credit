package top.palexu.blockchaincredit.report.service;

import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.Factor;

import java.util.Map;

/**
 * @author xjy
 */
public interface ReportService {
    /**
     * 用户-融合信用报告
     * 需要 subject、biztype 2个参数
     * 会取出所有provider提供的数据并进行融合
     *
     * @param context
     * @return
     */
    Map<String, Factor> singleReport(ReportContext context);

    /**
     * 用户-单商户信用报告
     * 需要provider、subject、biztype 三个参数
     * 只取出指定provider的数据进行报告计算
     *
     * @param context
     * @return
     */
    Map<String, Factor> mixedReport(ReportContext context);
}
