package top.palexu.blockchaincredit.report.service;

import top.palexu.blockchaincredit.report.model.TemplateDo;

public interface ManageService {
    boolean insertTemplate(TemplateDo templateDo, String pname);

    boolean deleteTemplate(Long templateId, String pname);

    boolean updateTemplate(TemplateDo templateDo, String pname);
}
