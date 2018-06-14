package top.palexu.blockchaincredit.report.engine.script.common

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class Phone implements IScript {
    @Override
    void execute(ReportContext ctx) {
        ctx.addFactorResult("手机号", ctx.getNaturePerson().getPhone())
    }
}
