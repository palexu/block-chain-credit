package top.palexu.blockchaincredit.credit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;

/**
 * @author xjy
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    CreditDataStoreService creditDataStoreService;

    @PostMapping("/data/save")
    public boolean receiveData(@RequestBody CreditData creditData) {

        //todo 接受数据，保存到数据库和区块链
        creditDataStoreService.insertCreditDataContent(creditData);
        //todo 1.校验商户是否有推送该bizType数据的权限
        return true;
    }
}
