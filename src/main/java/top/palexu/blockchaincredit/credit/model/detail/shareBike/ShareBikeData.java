package top.palexu.blockchaincredit.credit.model.detail.shareBike;

import lombok.Data;
import top.palexu.blockchaincredit.credit.model.NaturePerson;
import top.palexu.blockchaincredit.credit.model.detail.OverdueRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * 共享单车-信用信息
 *
 * @author xjy
 */
@Data
public class ShareBikeData {
    private NaturePerson naturePerson;

    /**
     * 还车逾期信息
     */
    private List<OverdueRecord> returnBikeOverdueRecord = new ArrayList<>();
}
