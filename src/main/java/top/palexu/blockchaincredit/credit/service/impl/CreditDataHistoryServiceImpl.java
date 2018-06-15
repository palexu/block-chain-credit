package top.palexu.blockchaincredit.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.dao.CreditMongo;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataContent;
import top.palexu.blockchaincredit.credit.model.CreditDataRow;
import top.palexu.blockchaincredit.credit.service.CreditDataHistoryService;
import top.palexu.blockchaincredit.credit.vo.CreditDataHistory;
import top.palexu.blockchaincredit.credit.vo.CreditDataHistoryItem;

import java.util.List;
import java.util.Map;

@Service
public class CreditDataHistoryServiceImpl implements CreditDataHistoryService {
    @Autowired
    CreditMongo creditMongo;

    @Override
    public CreditDataHistory getHistory(String provider, String subject, String bizType) {
        CreditData creditData = creditMongo.selectOne(provider, subject, bizType);
        if (creditData == null) {
            return null;
        }

        CreditDataHistory histories = new CreditDataHistory();

        CreditDataContent prev = null;
        for (CreditDataContent curr : creditData.getDatas()) {
            CreditDataHistoryItem item = new CreditDataHistoryItem(provider, subject, bizType, curr.getPrint(),
                                                                   curr.getGmtCreated());
            item.setTrxHash(curr.getTrxHash());
            histories.getHistories().add(item);
            //比较两者的区别
            this.compareHistory(item, prev, curr);
            prev = curr;
        }

        return histories;
    }

    /**
     * 对历史记录进行比较
     * todo 现只能识别增加大类，和细类下数量的改变
     *
     * @param item
     * @param prev
     * @param curr
     */
    private void compareHistory(CreditDataHistoryItem item, CreditDataContent prev, CreditDataContent curr) {
        assert curr != null;


        if (prev == null) {
            prev = new CreditDataContent();
        }

        Map<String, List<CreditDataRow>> prevData = prev.getData();
        Map<String, List<CreditDataRow>> currData = curr.getData();

        //判断大类
        for (String key : currData.keySet()) {
            if (!prevData.containsKey(key)) {
                item.addOpPair("增加", "大类" + key);
                item.addOpPair("增加", "在" + key + "下增加" + currData.get(key).size() + "条记录");
                continue;
            }

            //进入大类判断细类
            List<CreditDataRow> prevRows = prevData.get(key);
            List<CreditDataRow> currRows = currData.get(key);

            if ((currRows.size() - prevRows.size()) > 0) {
                item.addOpPair("增加", "在" + key + "下增加" + (currRows.size() - prevRows.size()) + "条记录");
            }
        }
    }
}
