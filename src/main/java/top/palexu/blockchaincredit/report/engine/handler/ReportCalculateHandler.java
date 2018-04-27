package top.palexu.blockchaincredit.report.engine.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.GroovyScriptLoader;
import top.palexu.blockchaincredit.report.engine.script.ScriptProcessor;

import java.util.List;

@Component
public class ReportCalculateHandler extends AbstractHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setUp(@Qualifier(value = "dataPostHandler") AbstractHandler next) {
        super.next = next;
    }

    @Override
    public void process(ReportContext context) {
        //1.获取groovy脚本实体
        List<ScriptProcessor> scriptProcessors = GroovyScriptLoader.parse(context.getCalculateHelper().getScriptDos());

        //2.调用实体进行计算
        for (ScriptProcessor processor : scriptProcessors) {
            processor.invokeMethod(context);
        }
    }
}
