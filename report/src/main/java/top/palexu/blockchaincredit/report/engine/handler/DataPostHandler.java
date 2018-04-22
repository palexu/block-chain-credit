package top.palexu.blockchaincredit.report.engine.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.service.IDataPost;

@Component
public class DataPostHandler extends AbstractHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IDataPost dataPost;

    @Autowired
    public void setUp(@Qualifier(value = "dataSaveHandler") AbstractHandler next) {
        super.next = next;
    }

    @Override
    public void process(ReportContext context) {

        dataPost.handle(context);
        logger.info(this.getClass().getName());
    }
}
