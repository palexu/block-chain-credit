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

    private String value;

    BizTypeEnum(String bizType) {
        this.setValue(bizType);
    }

    public static BizTypeEnum get(String bizType) {
        for (BizTypeEnum i : BizTypeEnum.values()) {
            if (i.getValue().equals(bizType)) {
                return i;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
