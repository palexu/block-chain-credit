package top.palexu.blockchaincredit.credit.vo;

import lombok.Data;

/**
 * 征信数据提供者
 */
@Data
public class DataProvider {
    /**
     * provider name
     */
    private String name;
    /**
     * provider的详细描述
     */
    private String desc;
    /**
     * 数据条数
     */
    private Long count;
    /**
     * 价格
     */
    private Long price;

}
