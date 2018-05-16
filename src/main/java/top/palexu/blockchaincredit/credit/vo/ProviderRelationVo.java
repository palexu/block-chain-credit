package top.palexu.blockchaincredit.credit.vo;

import lombok.Data;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;
import top.palexu.blockchaincredit.report.vo.TemplateVo;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProviderRelationVo {
    List<ProviderBiztypeRelation> relations = new ArrayList<>();
    List<TemplateVo> templateDos = new ArrayList<>();
}
