package top.palexu.blockchaincredit.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.dao.ProviderBiztypeRelationMapper;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;
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

    @Autowired
    ProviderBiztypeRelationMapper pbRelationMapper;

    public Long findTemplateIdByBiztypeProvider(String bizType, String provider) {
        ProviderBiztypeRelation r = pbRelationMapper.selectByBizTypeProvider(bizType, provider);
        if (r == null) {
            return null;
        }
        TemplateDo td = templateDoMapper.selectByPrimaryKey(r.getTemplateId());
        return td == null ? null : td.getId();
    }

    public Map<String, FactorDo> findFactorByTemplateId(long templateId) {
        List<Long> factorIds = relationMapper.findFactorIdByTemplateId(templateId);

        Map<String, FactorDo> factors = new HashMap<>();
        for (Long id : factorIds) {
            FactorDo factorDo = factorDoMapper.selectByPrimaryKey(id);
            if (factorDo != null)
                factors.put(factorDo.getName(), factorDo);
            else{
                System.out.print("123");
            }
        }

        return factors;
    }
}
