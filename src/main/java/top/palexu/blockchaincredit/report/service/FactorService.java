package top.palexu.blockchaincredit.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.report.dao.FactorDoMapper;
import top.palexu.blockchaincredit.report.dao.FactorTemplateRelationMapper;
import top.palexu.blockchaincredit.report.dao.TemplateDoMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.TemplateDo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FactorService {
    @Autowired
    TemplateDoMapper templateDoMapper;

    @Autowired
    FactorDoMapper factorDoMapper;

    @Autowired
    FactorTemplateRelationMapper relationMapper;

    public Long findTemplateIdByBiztype(String bizType) {
        TemplateDo td = templateDoMapper.selectByBizType(bizType);
        return td == null ? null : td.getId();
    }

    public Map<String, FactorDo> findFactorByTemplateId(long templateId) {
        List<Long> factorIds = relationMapper.findFactorIdByTemplateId(templateId);

        Map<String, FactorDo> factors = new HashMap<>();
        for (Long id : factorIds) {
            FactorDo factorDo = factorDoMapper.selectByPrimaryKey(id);
            factors.put(factorDo.getName(), factorDo);
        }

        return factors;
    }
}
