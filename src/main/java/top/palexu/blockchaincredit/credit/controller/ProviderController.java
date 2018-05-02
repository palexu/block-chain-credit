package top.palexu.blockchaincredit.credit.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.credit.service.ProviderService;
import top.palexu.blockchaincredit.credit.vo.DataProvider;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/list/{bizType}")
    public ProviderListResult getProviderList(@PathVariable(value = "bizType") String bizType) {

        ProviderListResult providerListResult = new ProviderListResult();
        providerListResult.setDesc(bizType);
        providerListResult.setProviderList(providerService.getDataProviderList(bizType));
        return providerListResult;
    }

    @Data
    class ProviderListResult {
        String desc;
        List<DataProvider> providerList;
    }
}
