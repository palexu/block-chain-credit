package top.palexu.blockchaincredit.credit.dao;

import org.apache.ibatis.annotations.Param;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;

import java.util.List;

public interface ProviderBiztypeRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProviderBiztypeRelation record);

    int insertSelective(ProviderBiztypeRelation record);

    ProviderBiztypeRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProviderBiztypeRelation record);

    int updateByPrimaryKey(ProviderBiztypeRelation record);

    List<ProviderBiztypeRelation> selectByBizType(String bizType);

    List<ProviderBiztypeRelation> selectByProviderName(String pname);

    int deleteByTemplateIdAndProviderName(@Param("templateId") Long templateId, @Param("pname") String pame);
}