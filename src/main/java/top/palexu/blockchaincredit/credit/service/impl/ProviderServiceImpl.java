package top.palexu.blockchaincredit.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.dao.ProviderBiztypeRelationMapper;
import top.palexu.blockchaincredit.credit.dao.ProviderDoMapper;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;
import top.palexu.blockchaincredit.credit.service.ProviderService;
import top.palexu.blockchaincredit.credit.vo.DataProvider;
import top.palexu.blockchaincredit.credit.vo.ProviderRelationVo;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.TemplateDo;
import top.palexu.blockchaincredit.report.service.FactorService;
import top.palexu.blockchaincredit.report.vo.TemplateVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderBiztypeRelationMapper providerBiztypeRelationMapper;

    @Autowired
    ProviderDoMapper providerDoMapper;

    @Autowired
    TemplateDoMapper templateDoMapper;

    @Autowired
    FactorService factorService;

    @Override
    public List<DataProvider> getDataProviderList(String bizType) {
        List<DataProvider> providers = new ArrayList<>();
        List<ProviderBiztypeRelation> relations = providerBiztypeRelationMapper.selectByBizType(bizType);

        for (ProviderBiztypeRelation r : relations) {
            DataProvider provider = new DataProvider();
            providers.add(provider);

            provider.setName(r.getPname());
            provider.setPrice(r.getPrice());
            provider.setCount(r.getCount());
        }

        return providers;
    }

    @Override
    public ProviderRelationVo getBizTemByProvider(String pname) {
        ProviderRelationVo vo = new ProviderRelationVo();
        List<ProviderBiztypeRelation> relations = providerBiztypeRelationMapper.selectByProviderName(pname);

        vo.setRelations(relations);

        for (ProviderBiztypeRelation r : relations) {
            TemplateVo templateVo = new TemplateVo();

            //1.获取模版属性
            TemplateDo templateDo = templateDoMapper.selectByPrimaryKey(r.getTemplateId());
            templateVo.setId(templateDo.getId());
            templateVo.setBizType(templateDo.getBizType());
            templateVo.setName(templateDo.getName());
            templateVo.setGmtCreated(templateDo.getGmtCreated());
            templateVo.setGmtUpdated(templateDo.getGmtUpdated());

            //2.获取绑定的因子
            Map<String, FactorDo> factorDoMap = factorService.findFactorByTemplateId(templateDo.getId());
            templateVo.setFactorSelected(factorDoMap);

            //3.添加
            vo.getTemplateDos().add(templateVo);
        }

        return vo;
    }
}
