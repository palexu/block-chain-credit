package top.palexu.blockchaincredit.report.engine.service.creditcard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.Factor;
import top.palexu.blockchaincredit.report.engine.service.IDataPost;

import java.util.Map;

/**
 * @author xjy
 */
@Slf4j
@Component
public class CreditCardDataPost implements IDataPost {

    @Override
    public void handle(ReportContext context) {
        //1.填充所有因子的provider
        Map<String, Factor> map = context.getFactorMap();
        if (null == map || map.size() == 0) {
            log.error("报告计算，无数据,ctx={}", context);
            return;
        }

        for (Factor factor : map.values()) {
            factor.setProvider(context.getProvider());
        }
    }
}
