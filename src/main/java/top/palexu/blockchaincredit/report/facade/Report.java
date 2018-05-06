package top.palexu.blockchaincredit.report.facade;

import lombok.Data;
import top.palexu.blockchaincredit.report.engine.script.Factor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对外输出的报告
 */
@Data
public class Report {
    private String bizType;
    private String subject;

    private String reportName;
    private String desc;
    private List<Factor> factors = new ArrayList<>();
    private Date gmtCreated = new Date();
}
