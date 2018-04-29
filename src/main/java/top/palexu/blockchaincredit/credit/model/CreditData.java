package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

/**
 * 征信数据存储 mongo
 *
 * @author xjy
 */
@Data
public class CreditData extends CreditDataRecord {

    /** 数据内容 */
    String data;
    
}
