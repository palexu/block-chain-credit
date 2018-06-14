package top.palexu.blockchaincredit.report.engine.script.creditcard;

import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.IScript;

public class RecentHalfYearAllExpense implements IScript {

    @Override
    public void execute(ReportContext ctx) {
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
        ctx.addFactorResult("最近半年总支出", allout+"元")
    }
}
