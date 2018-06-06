package top.palexu.blockchaincredit.report.engine.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.service.IDataPre;

@Component
public class DataPreHandler extends AbstractHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IDataPre dataPre;

    @Autowired
    public void setUp(@Qualifier(value = "reportCalculateHandler") AbstractHandler next) {
        super.next = next;
    }

    @Override
    public void process(ReportContext context) throws Exception {

        dataPre.handle(context);
        logger.info(this.getClass().getName());

    }
}
