package top.palexu.blockchaincredit.report.engine;

import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.handler.AbstractHandler;

import javax.annotation.Resource;

/**
 * @author xjy
 */
@Component
public class ReportEngine {

    @Resource(name = "dataPreHandler")
    AbstractHandler handler;

    public void calculate(ReportContext context) {
        handler.run(context);
    }
}
