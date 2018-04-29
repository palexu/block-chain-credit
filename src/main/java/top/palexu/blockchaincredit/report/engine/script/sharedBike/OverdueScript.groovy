package top.palexu.blockchaincredit.report.engine.script.sharedBike

import top.palexu.blockchaincredit.credit.model.detail.shareBike.ShareBikeData
import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

public class OverdueScript implements IScript {

    @Override
    public void execute(ReportContext ctx) {
        ShareBikeData shareBikeData = ctx.getRawData() as ShareBikeData
        ctx.addFactorResult("共享单车违章停放次数", shareBikeData.getReturnBikeOverdueRecord().size())
    }
}
