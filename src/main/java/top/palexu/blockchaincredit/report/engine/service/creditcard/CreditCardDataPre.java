package top.palexu.blockchaincredit.report.engine.service.creditcard;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardData;
import top.palexu.blockchaincredit.credit.model.detail.shareBike.ShareBikeData;
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
    public void handle(ReportContext context) {

        CreditData data = dataStoreService.selectCreditData(context.getProvider(), context.getSubject(),
                                                            context.getBizType().getValue());

        //1.读取征信数据
        //todo 想个办法能够智能地解析数据，而不是在这里手动parse
        switch (context.getBizType().getValue()) {
            case "sharedBike":
                context.setRawData(JSON.parseObject(data.getData(), ShareBikeData.class));
                break;
            case "creditCard":
                context.setRawData(JSON.parseObject(data.getData(), CreditCardData.class));
                break;
            default:
                log.error("无法解析数据,bizType={},data={}", context.getBizType(), data);
                break;
        }

    }


}
