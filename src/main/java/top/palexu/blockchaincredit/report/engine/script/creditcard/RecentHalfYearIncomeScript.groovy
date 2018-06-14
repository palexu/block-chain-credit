package top.palexu.blockchaincredit.report.engine.script.creditcard

import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class RecentHalfYearIncomeScript implements IScript {
    @Override
    void execute(ReportContext ctx) {
        def expense = ctx.getRawData().data.get("收入");
        def sorted = expense.groupBy { it.description }
                .sort { a, b -> b.value.size() - a.value.size() }
        def data = []
        Iterator it = sorted.iterator()
        int i = 0
        while (it.hasNext()) {
            if (i >= 10) {
                break
            }
            def item = it.next();
            Map<String, String> entry = new HashMap<String, String>()
            entry.put("name", item.key)
            entry.put("value", item.value.size())
            data.add(entry)
            i++
        }
        ctx.addFactorResult("最近半年收入类型", data)
    }
}
