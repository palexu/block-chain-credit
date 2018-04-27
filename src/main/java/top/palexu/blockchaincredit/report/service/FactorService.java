package top.palexu.blockchaincredit.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.report.dao.FactorDoMapper;
import top.palexu.blockchaincredit.report.dao.FactorTemplateRelationMapper;
import top.palexu.blockchaincredit.report.dao.ScriptDoMapper;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.ScriptDo;

import java.util.*;

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

    public Map<String, FactorDo> findFactorByTemplateId(long templateId) {
        List<Long> factorIds = relationMapper.findFactorIdByTemplateId(templateId);

        Map<String, FactorDo> factors = new HashMap<>();
        for (Long id : factorIds) {
            FactorDo factorDo = factorDoMapper.selectByPrimaryKey(id);
            factors.put(factorDo.getName(), factorDo);
        }

        return factors;
    }

    public List<ScriptDo> findScriptByTemplateId(long templateId) {
        Map<String, FactorDo> factors = this.findFactorByTemplateId(templateId);
        Set<Long> scriptIdSet = new HashSet<>();
        for (FactorDo d : factors.values()) {
            scriptIdSet.add(d.getScriptId());
        }
        List<ScriptDo> scripts = new ArrayList<>();
        for (Long id : scriptIdSet) {
            scripts.add(scriptDoMapper.selectByPrimaryKey(id));
        }
        return scripts;
    }
}
