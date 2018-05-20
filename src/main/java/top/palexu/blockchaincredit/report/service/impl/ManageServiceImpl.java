package top.palexu.blockchaincredit.report.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.dao.ProviderBiztypeRelationMapper;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;
import top.palexu.blockchaincredit.report.dao.FactorTemplateRelationMapper;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.TemplateDo;
import top.palexu.blockchaincredit.report.service.ManageService;

import java.util.Date;

@Slf4j
@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ProviderBiztypeRelationMapper providerRelationMapper;

    @Autowired
    FactorTemplateRelationMapper factorTemplateRelationMapper;

    @Autowired
    TemplateDoMapper templateDoMapper;

    @Override
    public boolean insertTemplate(TemplateDo templateDo, String pname) {
        try {
            templateDo.setGmtCreated(new Date());
            templateDo.setGmtUpdated(new Date());
            templateDoMapper.insert(templateDo);

            ProviderBiztypeRelation providerBiztypeRelation = new ProviderBiztypeRelation();
            providerBiztypeRelation.setBname(templateDo.getBizType());
            providerBiztypeRelation.setPname(pname);
            providerBiztypeRelation.setTemplateId(templateDo.getId());
            providerBiztypeRelation.setGmtCreated(new Date());
            providerBiztypeRelation.setGmtUpdated(new Date());
            providerRelationMapper.insert(providerBiztypeRelation);

            return true;
        } catch (Exception e) {
            log.error("insertTemplate", e);
            return false;
        }
    }

    @Override
    public boolean deleteTemplate(Long templateId, String pname) {
        try {
            providerRelationMapper.deleteByTemplateIdAndProviderName(templateId, pname);
            templateDoMapper.deleteByPrimaryKey(templateId);
            return true;
        } catch (Exception e) {
            log.error("deleteTemplate", e);
            return false;
        }
    }

    @Override
    public boolean updateTemplate(TemplateDo templateDo, String pname) {
        try {
            templateDoMapper.updateByPrimaryKeySelective(templateDo);
            ProviderBiztypeRelation relation = new ProviderBiztypeRelation();
            relation.setTemplateId(templateDo.getId());
            relation.setPname(pname);
            relation.setBname(templateDo.getBizType());
            relation.setGmtUpdated(new Date());
            providerRelationMapper.updateByTemplateIdSelective(relation);
            return true;
        } catch (Exception e) {
            log.error("updateTemplate", e);
            return false;
        }
    }
}
