package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

import java.util.Date;

/**
 * 每一条数据记录
 * 「谁」 什么时候 在哪里 「做了什么」 结果
 *
 * @author xjy
 */
@Data
public class CreditDataRow {
    /**
     * 可以保存金额数字、文本、对象等
     */
    Object value;

    /**
     * 描述，感觉没啥用
     */
    String description;

    /**
     * 地址
     */
    String address;

    /**
     * 该记录产生的时间
     */
    Date gmtCreated;
}
