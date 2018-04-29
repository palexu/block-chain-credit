package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

/**
 * 数据的保存记录,只用于读取
 */
@Data
public class CreditDataRecord {
    /** 主键 */
    String id;

    //========= 需要手动传入的数据

    /** 数据提供者 */
    String provider;

    /** 数据所描述主体 */
    String subject;

    /** 场景 */
    String bizType;

    //========== 计算所得的数据

    /** 数据指纹 */
    String print;
}
