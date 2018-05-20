package top.palexu.blockchaincredit.report.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.palexu.blockchaincredit.report.dao.FactorDoMapper;
import top.palexu.blockchaincredit.report.dao.FactorTemplateRelationMapper;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.FactorTemplateRelation;
import top.palexu.blockchaincredit.report.model.TemplateDo;
import top.palexu.blockchaincredit.report.service.ManageService;

import java.util.Date;
import java.util.List;

//todo 完善controller
@RestController()
@RequestMapping(value = "/api/report/manage")
@Slf4j
public class ReportManagerController {
    @Autowired
    FactorDoMapper factorDoMapper;

    @Autowired
    FactorTemplateRelationMapper factorTemplateRelation;

    @Autowired
    TemplateDoMapper templateDoMapper;

    @Autowired
    ManageService manageService;

    @PostMapping("/factor/insert")
    public boolean addFactor(@RequestParam Long templateId, @RequestBody FactorDo factorDo) {

        try {
            factorDo.setGmtCreated(new Date());
            factorDo.setGmtUpdated(new Date());
            factorDoMapper.insert(factorDo);

            FactorTemplateRelation relation = new FactorTemplateRelation();
            relation.setFactorId(factorDo.getId());
            relation.setTemplateId(templateId);
            relation.setGmtCreated(new Date());
            relation.setGmtUpdated(new Date());
            factorTemplateRelation.insert(relation);
            return true;
        } catch (Exception e) {
            log.error("addFactor", e);
            return false;
        }

    }

    @PostMapping("/factor/delete")
    public boolean deleteFactor(@RequestParam Long templateId, @RequestParam Long factorId) {
        try {
            factorDoMapper.deleteByPrimaryKey(factorId);
            factorTemplateRelation.deleteByFactorIdAndTemplateId(templateId, factorId);
            return true;
        } catch (Exception e) {
            log.error("deleteFactor", e);
            return false;
        }
    }

    @PostMapping("/factor/update")
    public boolean updateFactor(@RequestBody FactorDo factorDo) {
        factorDo.setGmtUpdated(new Date());
        return factorDoMapper.updateByPrimaryKeySelective(factorDo) > 0;
    }

    @PostMapping("/template/insert")
    public boolean addTemplate(@RequestBody TemplateDo templateDo, @RequestParam String provider) {
        return manageService.insertTemplate(templateDo, provider);
    }

    @PostMapping("/template/delete")
    public boolean deleteTemplate(@RequestParam Long templateId, @RequestParam String pname) {
        return manageService.deleteTemplate(templateId, pname);
    }

    @PostMapping("/template/update")
    public boolean updateTemplate(@RequestBody TemplateDo templateDo, @RequestParam String pname) {
        return manageService.updateTemplate(templateDo, pname);
    }

    public List<FactorDo> selectAllFactor() {
        return null;
    }
}
