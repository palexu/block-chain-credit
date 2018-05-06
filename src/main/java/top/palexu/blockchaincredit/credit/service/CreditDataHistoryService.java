package top.palexu.blockchaincredit.credit.service;

import top.palexu.blockchaincredit.credit.vo.CreditDataHistory;

public interface CreditDataHistoryService {
    /**
     * 获取所有操作历史
     *
     * @param provider
     * @param subject
     * @param bizType
     * @return
     */
    CreditDataHistory getHistory(String provider, String subject, String bizType);
}
