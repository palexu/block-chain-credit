package top.palexu.blockchaincredit.credit.service;

import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;

import java.util.List;

/**
 * 征信数据读写
 *
 * @author xjy
 */
public interface CreditDataStoreService {

    /**
     * 保存征信数据
     * print由这四个入参数算出来
     *
     * @param provider 数据提供者
     * @param subject  主体
     * @param bizType  业务场景
     * @param data     数据描述的主体
     */
    boolean insertCreditDataContent(CreditData creditData);

    /**
     * 查询征信数据
     *
     * @param provider 数据提供者
     * @param subject  主体
     * @param bizType  业务场景
     */
    CreditData selectCreditData(CreditData creditData);

    /**
     * 查询征信数据
     *
     * @param provider 数据提供者
     * @param subject  主体
     * @param bizType  业务场景
     */
    CreditData selectCreditData(String provider, String subject, String bizType);

    /**
     * 查询征信数据
     *
     * @param subject 主体
     * @param bizType 业务场景
     */
    List<CreditData> selectCreditData(String subject, String bizType);

    /**
     * 获取subject下所有数据
     *
     * @param subject
     * @return
     */
    List<CreditDataRecord> selectAllRecordBySubject(String subject);

    /**
     * 获取subject下所有数据
     *
     * @param subject
     * @return
     */
    List<CreditDataRecord> selectAllRecordBySubjectBizType(String subject,String bizType);

    /**
     * 删除征信数据
     *
     * @param provider 数据提供者
     * @param subject  主体
     * @param bizType  业务场景
     * @return
     */
    boolean deleteCreditData(CreditData creditData);

}
