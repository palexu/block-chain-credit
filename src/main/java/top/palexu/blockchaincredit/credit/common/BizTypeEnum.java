package top.palexu.blockchaincredit.credit.common;

/**
 * @author xjy
 */

public enum BizTypeEnum {
    /**
     * 信用卡
     */
    creditCard("creditCard"),

    /**
     * 共享单车
     */
    sharedBike("sharedBike");

    public String value;

    BizTypeEnum(String bizType) {
        this.value = bizType;
    }

    public static BizTypeEnum get(String bizType) {
        for (BizTypeEnum i : BizTypeEnum.values()) {
            if (i.value.equals(bizType)) {
                return i;
            }
        }
        return null;
    }
}
