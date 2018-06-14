package top.palexu.blockchaincredit.report.engine.script.common

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class Name implements IScript {
    @Override
    void execute(ReportContext ctx) {
        ctx.addFactorResult("姓名", ctx.getNaturePerson().getName())
    }
}
