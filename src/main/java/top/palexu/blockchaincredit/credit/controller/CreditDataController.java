package top.palexu.blockchaincredit.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;

@RestController
@RequestMapping(value = "/api/creditData")
public class CreditDataController {

    @Autowired
    CreditDataStoreService creditDataStoreService;

    @GetMapping("/trial/get/{provider}/{subject}/{bizType}")
    public CreditData trailGetCreditData(@PathVariable(value = "provider") String provider,
                                         @PathVariable(value = "subject") String subject,
                                         @PathVariable(value = "bizType") String bizType) {
        //todo 进行限额
        return creditDataStoreService.selectCreditData(provider, subject, bizType);
    }
}
