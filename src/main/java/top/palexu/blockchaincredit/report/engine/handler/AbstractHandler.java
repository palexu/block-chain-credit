package top.palexu.blockchaincredit.report.engine.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import top.palexu.blockchaincredit.credit.common.CreditPrintNotMatchException;
import top.palexu.blockchaincredit.report.ReportContext;

/**
 * @author xjy
 */
@Slf4j
public abstract class AbstractHandler {
    @Setter
    @Getter
    public AbstractHandler next;

    public abstract void process(ReportContext context) throws Exception;

    public void run(ReportContext context) {
        AbstractHandler handler = this;
        try {
            while (handler != null) {
                handler.process(context);
                handler = handler.next;
            }
        } catch (Exception e) {
            if (e instanceof CreditPrintNotMatchException) {
                context.setSuccess(false);
                context.setErrorMsg(e.getMessage());
                return;
            }
            log.error("报告计算链", e);

        }
    }
}

