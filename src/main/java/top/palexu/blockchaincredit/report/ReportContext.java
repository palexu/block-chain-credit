package top.palexu.blockchaincredit.report;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.report.engine.script.Factor;

import java.util.Map;

/**
 * @author xjy
 */
@Data
public class ReportContext {
    Logger logger = LoggerFactory.getLogger(ReportContext.class);

    /**
     * 一般来说是 idcard，还可以是 phone
     */
    String subject;

    /**
     * 数据提供者
     */
    String provider;

    /**
     * 业务类型
     */
    BizTypeEnum bizType;

    /**
     * 待计算的数据
     */
    Object rawData;

    /**
     * 计算中需要用到的工具
     */
    CalculateHelper calculateHelper;

    /**
     * 因子列表
     */
    Map<String, Factor> factorMap;

    /**
     * 报告结果
     */
    Object reportResult;

    public ReportContext() {
    }

    public ReportContext(String subject, String provider, String bizType) {
        this.subject = subject;
        this.provider = provider;
        this.bizType = BizTypeEnum.get(bizType);
    }

    /**
     * 往factor中保存数据
     *
     * @param name
     * @param value
     * @return
     */
    public void addFactorResult(String name, Object value) {
        if (factorMap.containsKey(name)) {
            factorMap.get(name).setValue(value);
        } else {
            //不做处理
            logger.info("报告上下文,provider={},subject={},bizType={},该报告不存在因子{}", this.provider, this.subject,
                        this.bizType.value, name);
        }
    }
}

