package top.palexu.blockchaincredit.report.controller;

import org.springframework.web.bind.annotation.RestController;
import top.palexu.blockchaincredit.report.model.Factor;

import java.util.List;

//todo 完善controller
@RestController("/report/manage")
public class ReportManagerController {

    public boolean addFactor(Factor factor) {
        return false;
    }

    public boolean deleteFactor(long id) {
        return false;
    }

    public boolean updateFactor(Factor factor) {
        return false;
    }

    public List<Factor> selectAllFactor() {
        return null;
    }
}
