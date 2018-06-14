package top.palexu.blockchaincredit.report.engine.script.creditcard

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class RecentHalfYearExpenseAndIncome implements IScript {
    @Override
    void execute(ReportContext ctx) {
        def expense = ctx.getRawData().data.get("支出")
        expense.each {
            if (it.value instanceof String) {
                try {
                    it.value = Long.valueOf(it.value as String)
                } catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }
        def allout = expense.collect { it.value as long }.sum() / 100
        def income = ctx.getRawData().data.get("收入")
        income.each {
            if (it.value instanceof String) {
                try {
                    it.value = Long.valueOf(it.value as String)
                } catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }
        def allin = income.collect { it.value as long}.sum() / 100
        ctx.addFactorResult("最近半年净收入", (allin - allout) + "元")
    }
}
