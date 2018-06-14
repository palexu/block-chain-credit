package top.palexu.blockchaincredit.report.engine.script.creditcard

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class RecentHalfYearAllIncome implements IScript {
    @Override
    void execute(ReportContext ctx) {
        def expense = ctx.getRawData().data.get("收入")
        expense.each {
            if (it.value instanceof String) {
                try {
                    it.value = Long.valueOf(it.value as String)
                } catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }
        def allout = expense.collect { it.value }.sum() / 100
        ctx.addFactorResult("最近半年总收入", allout + "元")
    }

}
