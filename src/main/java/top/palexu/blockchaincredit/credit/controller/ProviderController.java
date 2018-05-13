package top.palexu.blockchaincredit.credit.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.palexu.blockchaincredit.credit.service.ProviderService;
import top.palexu.blockchaincredit.credit.vo.DataProvider;
import top.palexu.blockchaincredit.credit.vo.ProviderRelationVo;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/list/{bizType}")
    public ProviderListResult getProviderList(@PathVariable(value = "bizType") String bizType) {

        ProviderListResult providerListResult = new ProviderListResult();
        providerListResult.setBizType(bizType);
        providerListResult.setProviderList(providerService.getDataProviderList(bizType));
        return providerListResult;
    }

    @Data
    class ProviderListResult {
        String bizType;
        List<DataProvider> providerList;
    }

    @GetMapping("/list/template")
    public ProviderRelationVo getTemplateOfProvider(@RequestParam(value = "provider") String pname) {
        return providerService.getBizTemByProvider(pname);
    }
}
