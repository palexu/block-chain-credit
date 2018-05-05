package top.palexu.blockchaincredit.report.engine.script.sharedBike

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

public class OverdueScript implements IScript {

    @Override
    public void execute(ReportContext ctx) {
        ctx.addFactorResult("共享单车违章停放次数", ctx.getRawData().getData().get("overDue").size())
    }
}
