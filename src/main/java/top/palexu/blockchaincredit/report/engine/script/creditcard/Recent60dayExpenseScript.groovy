package top.palexu.blockchaincredit.report.engine.script.creditcard

import com.alibaba.fastjson.JSON
import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class Recent60dayExpenseScript implements IScript {
    @Override
    void execute(ReportContext ctx) {
        def data = JSON.parse("[\n" +
                "            {value: 335, name: '西瓜'},\n" +
                "            {value: 310, name: '苹果'},\n" +
                "            {value: 234, name: '桃子'},\n" +
                "            {value: 135, name: '视频广告'},\n" +
                "            {value: 135, name: '视频广告2'},\n" +
                "            {value: 1548, name: '搜索引擎'}\n" +
                "          ]")
        ctx.addFactorResult("最近60天支出类型", data)
    }
}
