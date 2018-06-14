package top.palexu.blockchaincredit.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.credit.util.DataMockUtil;

@RestController
@RequestMapping(value = "/api/mockBankData")
public class MockDataController {
    @Autowired
    DataMockUtil util;

    @GetMapping("/shardBike")
    public void mockShardBike() {
        util.mockDataIntoDb(BizTypeEnum.sharedBike);
    }

    @GetMapping("/creditCard")
    public void mockCreditCard() {
        util.mockDataIntoDb(BizTypeEnum.creditCard);
    }

    @GetMapping("/all")
    public void mockAll() {
        this.mockShardBike();
        this.mockCreditCard();
    }

    @GetMapping("/cleanAll")
    public void clean() {
        util.cleanUpMockDataFromDb(BizTypeEnum.creditCard);
        util.cleanUpMockDataFromDb(BizTypeEnum.sharedBike);
    }
}
