package top.palexu.blockchaincredit.report.vo;

import lombok.Data;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.TemplateDo;

import java.util.Map;

@Data
public class TemplateVo extends TemplateDo {
    /**
     * 已选择的
     */
    Map<String,FactorDo> factorSelected;
}
