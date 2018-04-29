package top.palexu.blockchaincredit.report.engine.script;

import lombok.Data;

import java.util.Date;

/**
 * @author xjy
 */
@Data
public class Factor {
    private String name;
    private Object value;
    private String desc;
    /**
     * 维度
     */
    private String type;
    private Date gmtCreated = new Date();
}
