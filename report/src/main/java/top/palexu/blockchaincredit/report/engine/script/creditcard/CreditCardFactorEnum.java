package top.palexu.blockchaincredit.report.engine.script.creditcard;

/**
 * @author xjy
 */

public enum CreditCardFactorEnum {
    OVERDUE_TOTAL_CTN("信用卡逾期总次数");

    String desc;

    CreditCardFactorEnum(String desc) {
        this.desc = desc;
    }
}
