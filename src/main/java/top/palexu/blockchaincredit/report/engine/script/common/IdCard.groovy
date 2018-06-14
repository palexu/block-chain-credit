package top.palexu.blockchaincredit.report.engine.script.common

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class IdCard implements IScript {
    @Override
    void execute(ReportContext ctx) {
        ctx.addFactorResult("身份证", ctx.getNaturePerson().getIdCard())
    }
}
