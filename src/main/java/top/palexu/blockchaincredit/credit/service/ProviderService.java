package top.palexu.blockchaincredit.credit.service;

import top.palexu.blockchaincredit.credit.vo.DataProvider;
import top.palexu.blockchaincredit.credit.vo.ProviderRelationVo;

import java.util.List;

public interface ProviderService {
    /**
     * 获取指定bizType下有哪些数据提供者
     *
     * @param bizType
     * @return
     */
    List<DataProvider> getDataProviderList(String bizType);

    /**
     * 获取provider下的所有bizType以及对应的templateid
     *
     * @param pname
     * @return
     */
    ProviderRelationVo getBizTemByProvider(String pname);

}
