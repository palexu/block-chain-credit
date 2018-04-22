package top.palexu.blockchaincredit.report.engine.script.creditcard

import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardData
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardOverdueRecord
import top.palexu.blockchaincredit.report.ReportContext
import top.palexu.blockchaincredit.report.engine.script.IScript

class OverdueScript implements IScript {
    @Override
    void execute(ReportContext ctx) {
        CreditCardData creditCardData = ctx.getRawData() as CreditCardData
        if (creditCardData == null) {
            throw new NullPointerException("待计算的数据不能是null")
        }

        List<CreditCardOverdueRecord> overdueRecordList = creditCardData.getCreditCardOverdueRecords()
        ctx.addFactorResult(CreditCardFactorEnum.OVERDUE_TOTAL_CTN.desc, overdueRecordList.size())
    }
}
