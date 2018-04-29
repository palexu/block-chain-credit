package top.palexu.blockchaincredit.report.facade;

public interface SearchReportService {

    /**
     * 根据身份证号\信用编号查询所有相关报告
     *
     * @param subject
     * @return
     */
    String search(String subject);
}
