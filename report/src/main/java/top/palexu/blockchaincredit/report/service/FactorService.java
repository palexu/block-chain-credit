package top.palexu.blockchaincredit.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.report.dao.FactorScriptRelationMapper;
import top.palexu.blockchaincredit.report.dao.TemplateMapper;
import top.palexu.blockchaincredit.report.model.FactorDo;

import java.util.List;

public class FactorService {
    @Autowired
    TemplateMapper templateMapper;

    @Autowired
    FactorScriptRelationMapper relationMapper;

    public List<FactorDo> findByTemplate(long templateId) {
        return null;
    }
}
