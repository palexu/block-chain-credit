package top.palexu.blockchaincredit.report.engine.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.service.IDataSave;

@Component
public class DataSaveHandler extends AbstractHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IDataSave dataSave;

    @Override
    public void process(ReportContext context) {

        dataSave.handle(context);
        logger.info(this.getClass().getName());

    }
}
