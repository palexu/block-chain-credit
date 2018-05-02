package top.palexu.blockchaincredit.credit.service;

import top.palexu.blockchaincredit.credit.vo.DataProvider;

import java.util.List;

public interface ProviderService {
    /**
     * 获取指定bizType下有哪些数据提供者
     *
     * @param bizType
     * @return
     */
    List<DataProvider> getDataProviderList(String bizType);

}
