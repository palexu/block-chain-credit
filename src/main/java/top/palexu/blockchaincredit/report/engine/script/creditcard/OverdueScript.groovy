package top.palexu.blockchaincredit.report.engine.script.creditcard

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class OverdueScript implements IScript {
    @Override
    void execute(ReportContext ctx) {
        ctx.addFactorResult(CreditCardFactorEnum.OVERDUE_TOTAL_CTN.desc, ctx.getRawData().getData().get("overDue").size())
    }
}
