package top.palexu.blockchaincredit.report.engine.service.creditcard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.service.IDataPre;

/**
 * @author xjy
 */
@Component
@Slf4j
public class CreditCardDataPre implements IDataPre {
    @Autowired
    CreditDataStoreService dataStoreService;

    @Override
    public void handle(ReportContext context) throws Exception {


        CreditData data = dataStoreService.selectCreditData(context.getProvider(), context.getSubject(),
                                                            context.getBizType().getValue());

        //1.读取征信数据
        context.setRawData(data.getLatestContent());

        //2.设置自然人信息
        context.setNaturePerson(data.getNaturePerson());

    }


}
