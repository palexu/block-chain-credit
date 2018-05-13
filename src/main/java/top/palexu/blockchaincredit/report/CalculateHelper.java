package top.palexu.blockchaincredit.report;

import lombok.Data;
import top.palexu.blockchaincredit.report.model.FactorDo;

import java.util.Map;

@Data
public class CalculateHelper {
    Map<String,FactorDo> factorDos;
}
