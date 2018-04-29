package top.palexu.blockchaincredit.report.facade;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchReportJson {
    private boolean status = true;
    private String errMsg = "";
    private List<Report> reports = new ArrayList<>();

    public void setSuccess() {
        this.status = true;
    }

    public void setFail(String errMsg) {
        this.status = false;
        this.errMsg = errMsg;
    }

}
