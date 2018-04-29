package top.palexu.blockchaincredit.credit.model.detail.creditCard;

import lombok.Data;
import top.palexu.blockchaincredit.credit.model.NaturePerson;

import java.util.ArrayList;
import java.util.List;

/**
 * 信用卡-信用信息
 *
 * @author xjy
 */
@Data
public class CreditCardData {

    private NaturePerson naturePerson = new NaturePerson();

    /**
     * 信用卡逾期信息
     */
    private List<CreditCardOverdueRecord> creditCardOverdueRecords = new ArrayList<>();

}
