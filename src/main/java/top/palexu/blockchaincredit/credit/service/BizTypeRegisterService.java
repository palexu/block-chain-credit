package top.palexu.blockchaincredit.credit.service;

/**
 * 商户认证bizType相关
 */
public interface BizTypeRegisterService {
    /**
     * 商户注册bizType
     *
     * @param provider
     * @param bizType
     * @return
     */
    boolean register(String provider, String bizType);
}
