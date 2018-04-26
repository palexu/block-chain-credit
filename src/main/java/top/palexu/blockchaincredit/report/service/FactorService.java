package top.palexu.blockchaincredit.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.report.dao.FactorDoMapper;
import top.palexu.blockchaincredit.report.dao.FactorTemplateRelationMapper;
import top.palexu.blockchaincredit.report.dao.ScriptDoMapper;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.ScriptDo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FactorService {
    @Autowired
    TemplateDoMapper templateDoMapper;

    @Autowired
    ScriptDoMapper scriptDoMapper;

    @Autowired
    FactorDoMapper factorDoMapper;

    @Autowired
    FactorTemplateRelationMapper relationMapper;

    public List<FactorDo> findFactorByTemplateId(long templateId) {
        List<Long> factorIds = relationMapper.findFactorIdByTemplateId(templateId);
        List<FactorDo> factors = new ArrayList<>();
        for (Long id : factorIds) {
            factors.add(factorDoMapper.selectByPrimaryKey(id));
        }
        return factors;
    }

    public List<ScriptDo> findScriptByTemplateId(long templateId) {
        List<FactorDo> factors = this.findFactorByTemplateId(templateId);
        Set<Long> scriptIdSet = new HashSet<>();
        for (FactorDo d : factors) {
            scriptIdSet.add(d.getScriptId());
        }
        List<ScriptDo> scripts = new ArrayList<>();
        for (Long id : scriptIdSet) {
            scripts.add(scriptDoMapper.selectByPrimaryKey(id));
        }
        return scripts;
    }
}
