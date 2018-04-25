package top.palexu.blockchaincredit.report.engine.service.creditcard;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.service.IDataPre;

/**
 * @author xjy
 */
@Component
public class CreditCardDataPre implements IDataPre {
    @Autowired
    CreditDataStoreService dataStoreService;

    @Override
    public void handle(ReportContext context) {

        CreditData data = dataStoreService.selectCreditData(context.getProvider(), context.getSubject(),
                                                            context.getBizType().value);


        //1.读取征信数据
        CreditCardData creditCardData = JSON.parseObject(data.getData(), CreditCardData.class);
        context.setRawData(creditCardData);

    }


}
