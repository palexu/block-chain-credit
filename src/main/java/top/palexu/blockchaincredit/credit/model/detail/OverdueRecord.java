package top.palexu.blockchaincredit.credit.model.detail;


import lombok.Data;

import java.util.Date;

/**
 * 逾期信息
 */
@Data
public class OverdueRecord {
    private String desc;
    private String address;
    private Date gmtCreated;
}
