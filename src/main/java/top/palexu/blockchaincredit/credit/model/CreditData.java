package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

/**
 * 征信数据存储 mongo
 *
 * @author xjy
 */
@Data
public class CreditData {

    /** 主键 */
    String id;

    //========= 需要手动传入的数据

    /** 数据提供者 */
    String provider;

    /** 数据所描述主体 */
    String subject;

    /** 场景 */
    String bizType;

    /** 数据内容 */
    String data;

    //========== 计算所得的数据

    /** 数据指纹 */
    String print;
}
