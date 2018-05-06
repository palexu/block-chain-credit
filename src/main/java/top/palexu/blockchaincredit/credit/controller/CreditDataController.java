package top.palexu.blockchaincredit.credit.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;
import top.palexu.blockchaincredit.credit.service.CreditDataHistoryService;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.credit.vo.CreditDataHistory;
import top.palexu.blockchaincredit.credit.vo.CreditDataHistoryItem;

import java.util.*;

@RestController
@RequestMapping(value = "/api/creditData")
public class CreditDataController {

    @Autowired
    CreditDataStoreService creditDataStoreService;

    @Autowired
    CreditDataHistoryService creditDataHistoryService;

    @GetMapping("/trial/get/{provider}/{subject}/{bizType}")
    public CreditData trailGetCreditData(@PathVariable(value = "provider") String provider,
                                         @PathVariable(value = "subject") String subject,
                                         @PathVariable(value = "bizType") String bizType) {
        //todo 进行限额
        return creditDataStoreService.selectCreditData(provider, subject, bizType);
    }

    @GetMapping("/history/{provider}/{subject}/{bizType}")
    public CreditDataHistory getHistory(@PathVariable(value = "provider") String provider,
                                        @PathVariable(value = "subject") String subject,
                                        @PathVariable(value = "bizType") String bizType) {
        return creditDataHistoryService.getHistory(provider, subject, bizType);
    }

    @GetMapping("/getWithHistory/{provider}/{subject}/{bizType}")
    public Map<String, GetWithHistoryResult> getWithHistory(@PathVariable(value = "provider") String provider,
                                                            @PathVariable(value = "subject") String subject,
                                                            @PathVariable(value = "bizType") String bizType) {
        GetWithHistoryResult result = new GetWithHistoryResult();
        result.setHistories(creditDataHistoryService.getHistory(provider, subject, bizType).getHistories());
        result.setCreditData(creditDataStoreService.selectCreditData(provider, subject, bizType));
        return Collections.singletonMap(provider, result);
    }

    @GetMapping("/getWithHistory/{subject}/{bizType}")
    public Map<String, GetWithHistoryResult> getAllWithHistory(@PathVariable(value = "subject") String subject,
                                                               @PathVariable(value = "bizType") String bizType) {
        List<CreditDataRecord> records = creditDataStoreService.selectAllRecordBySubjectBizType(subject, bizType);
        Map<String, GetWithHistoryResult> result = new HashMap<>(records.size());
        for (CreditDataRecord r : records) {
            String provider = r.getProvider();
            GetWithHistoryResult gr = new GetWithHistoryResult();
            gr.setHistories(creditDataHistoryService.getHistory(provider, subject, bizType).getHistories());
            gr.setCreditData(creditDataStoreService.selectCreditData(provider, subject, bizType));
            result.put(provider, gr);
        }

        return result;
    }

    @Data
    class GetWithHistoryResult {
        CreditData creditData;
        List<CreditDataHistoryItem> histories = new LinkedList<>();
    }
}
