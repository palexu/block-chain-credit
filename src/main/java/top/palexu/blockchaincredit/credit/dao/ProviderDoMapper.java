package top.palexu.blockchaincredit.credit.dao;

import top.palexu.blockchaincredit.credit.model.ProviderDo;

public interface ProviderDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProviderDo record);

    int insertSelective(ProviderDo record);

    ProviderDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProviderDo record);

    int updateByPrimaryKey(ProviderDo record);

    ProviderDo selectByProviderName(String name);
}