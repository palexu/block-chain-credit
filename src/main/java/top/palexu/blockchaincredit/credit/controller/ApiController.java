package top.palexu.blockchaincredit.credit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xjy
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/data/save")
    public boolean receiveData() {
        //todo 接受数据，保存到数据库和区块链
        //todo 1.校验商户是否有推送该bizType数据的权限
        //2. ........
        return true;
    }
}
