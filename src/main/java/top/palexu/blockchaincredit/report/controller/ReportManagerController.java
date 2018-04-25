package top.palexu.blockchaincredit.report.controller;

import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.report.model.FactorDo;

import java.util.List;

//todo 完善controller
@RestController("/report/manage")
public class ReportManagerController {

    public boolean addFactor(FactorDo factorDo) {
        return false;
    }

    public boolean deleteFactor(long id) {
        return false;
    }

    public boolean updateFactor(FactorDo factorDo) {
        return false;
    }

    public List<FactorDo> selectAllFactor() {
        return null;
    }
}
