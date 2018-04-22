package top.palexu.blockchaincredit.report.engine.handler;

import lombok.Getter;
import lombok.Setter;
import top.palexu.blockchaincredit.report.ReportContext;

/**
 * @author xjy
 */
public abstract class AbstractHandler {
    @Setter
    @Getter
    public AbstractHandler next;

    public abstract void process(ReportContext context);

    public void run(ReportContext context) {
        AbstractHandler handler = this;
        while (handler != null) {
            handler.process(context);
            handler = handler.next;
        }
    }
}

