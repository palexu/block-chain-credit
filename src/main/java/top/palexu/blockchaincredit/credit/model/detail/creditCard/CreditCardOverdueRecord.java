package top.palexu.blockchaincredit.credit.model.detail.creditCard;

import lombok.Data;
import top.palexu.blockchaincredit.credit.model.detail.OverdueRecord;

/**
 * @author xjy
 */
@Data
public class CreditCardOverdueRecord extends OverdueRecord {
    private long amount;
}
