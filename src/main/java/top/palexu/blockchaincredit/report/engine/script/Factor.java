package top.palexu.blockchaincredit.report.engine.script;

import lombok.Data;

/**
 * @author xjy
 */
@Data
public class Factor {
    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
