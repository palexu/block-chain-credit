package top.palexu.blockchaincredit.report;

import lombok.Data;
import top.palexu.blockchaincredit.report.model.FactorDo;
import top.palexu.blockchaincredit.report.model.ScriptDo;

import java.util.List;

@Data
public class CalculateHelper {
    List<FactorDo> factorDos;
    List<ScriptDo> scriptDos;
}
