package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * 每一版本的实际数据保存在这里
 * 相当于之前的creditData
 *
 * @author xjy
 */
@Data
public class CreditDataContent {
    /**
     * 其实就是代表了第几次修改,由creditMongo来设置
     */
    @NotNull Long version;

    /**
     * 指纹
     */
    String print;

    /**
     * 数据类型(比bizType更细化一下，暂时留为空)
     */
    String dataType;

    /**
     * 区块链交易记录地址hash,用于在explorer中查看交易详情
     */
    String trxHash;

    /**
     * 数据列
     * String 代表data的类型，例如 违约记录
     */
    Map<String, List<CreditDataRow>> data = new HashMap<>();

    /**
     * 数据写入时间
     */
    Date gmtCreated = new Date();

    public void putRow(String key, CreditDataRow row) {
        if (!data.containsKey(key)) {
            data.put(key, new LinkedList<>());
        }
        data.get(key).add(row);
    }

}
