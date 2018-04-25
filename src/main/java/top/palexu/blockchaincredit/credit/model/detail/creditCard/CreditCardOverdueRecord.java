package top.palexu.blockchaincredit.credit.model.detail.creditCard;

import lombok.Data;

import java.util.Date;

/**
 * @author xjy
 */
@Data
public class CreditCardOverdueRecord {
    private long amount;
    private String desc;
    private Date gmtCreate;
}
