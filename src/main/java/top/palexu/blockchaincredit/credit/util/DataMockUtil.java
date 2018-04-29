package top.palexu.blockchaincredit.credit.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.NaturePerson;
import top.palexu.blockchaincredit.credit.model.detail.OverdueRecord;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardData;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardOverdueRecord;
import top.palexu.blockchaincredit.credit.model.detail.shareBike.ShareBikeData;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;

import java.util.Date;
import java.util.Random;

/**
 * 用于模拟数据
 *
 * @author xjy
 */
@Component
@Slf4j
public class DataMockUtil {
    /** ============查询 三要素============== */
    public static final String PROVIDER = "DATAHUB";
    public static final String SUBJECT = "TEST01";
    //    public static final BizTypeEnum BIZ_TYPE = BizTypeEnum.creditCard;

    /** ============自然 三要素============== */
    public static final String NAME = "TEST01";
    public static final String ID_CARD = "110000199001012001";
    public static final String PHONE = "15900011111";

    @Autowired
    CreditDataStoreService service;

    /**
     * 传入数据类型，自动模拟数据
     * 注意，自然人是同一个,只能模拟单个人的数据
     *
     * @param bizTypeEnum
     * @return
     */
    public static CreditData mockData(BizTypeEnum bizTypeEnum) {
        CreditData creditData = new CreditData();

        //设置数据内容
        switch (bizTypeEnum) {
            case creditCard:
                //设置主体三要素
                setProSubBiz(creditData, BizTypeEnum.creditCard);
                creditData.setData(JSON.toJSONString(mockCreditCard()));
                break;
            case sharedBike:
                //设置主体三要素
                setProSubBiz(creditData, BizTypeEnum.sharedBike);
                creditData.setData(JSON.toJSONString(mockShareBikeData()));
                break;
            default:
                log.error("未找到{}对应的mock工具", bizTypeEnum);
                break;
        }

        log.info("{}", creditData);
        return creditData;
    }

    /**
     * 注意，自然人是同一个,只能模拟单个人的数据
     *
     * @return
     */
    public static CreditData plainCreditData() {
        CreditData creditData = new CreditData();

        //设置主体三要素
        setProSubBiz(creditData, BizTypeEnum.creditCard);

        //设置数据内容
        creditData.setData("hello world");

        return creditData;
    }

    /**
     * 将模拟数据保存入库
     *
     * @param bizTypeEnum
     */
    public void mockDataIntoDb(BizTypeEnum bizTypeEnum) {
        service.insertCreditData(mockData(bizTypeEnum));
    }

    /**
     * 将模拟数据从库删除
     *
     * @param bizTypeEnum
     */
    public void cleanUpMockDataFromDb(BizTypeEnum bizTypeEnum) {
        //因为mock无print，所以可以通过三要素删除
        service.deleteCreditData(mockData(bizTypeEnum));
    }

    /**
     * 模拟信用卡数据
     *
     * @return
     */
    private static CreditCardData mockCreditCard() {
        //模拟信用卡数据
        CreditCardData creditCardData = new CreditCardData();
        creditCardData.setNaturePerson(mockNaturePerson());

        //模拟逾期数据
        for (int i = 0; i < 10; i++) {
            creditCardData.getCreditCardOverdueRecords().add(mockOverDueRecord());
        }

        //todo 模拟信用卡其他数据...
        return creditCardData;
    }


    private static ShareBikeData mockShareBikeData() {
        //模拟共享单车数据
        ShareBikeData shareBikeData = new ShareBikeData();
        shareBikeData.setNaturePerson(mockNaturePerson());

        //模拟单车逾期
        for (int i = 0; i < 3; i++) {
            shareBikeData.getReturnBikeOverdueRecord().add(shardBikeOverDueRecord());
        }

        return shareBikeData;
    }


    /**
     * 设置主体三要素
     *
     * @param creditData
     */
    private static void setProSubBiz(CreditData creditData, BizTypeEnum bizTypeEnum) {
        creditData.setProvider(PROVIDER);
        creditData.setSubject(SUBJECT);
        creditData.setBizType(bizTypeEnum.getValue());
    }

    /**
     * mock自然人三要素
     *
     * @return
     */
    private static NaturePerson mockNaturePerson() {
        NaturePerson naturePerson = new NaturePerson();
        naturePerson.setName(NAME);
        naturePerson.setIdCard(ID_CARD);
        naturePerson.setPhone(PHONE);
        return naturePerson;
    }


    /**======================信用卡mock start================================*/

    /**
     * mock信用卡逾期信息
     *
     * @return
     */
    private static CreditCardOverdueRecord mockOverDueRecord() {
        Random random = new Random();

        CreditCardOverdueRecord overdueRecord = new CreditCardOverdueRecord();
        overdueRecord.setAmount(random.nextInt(100000));
        overdueRecord.setDesc("test");
        overdueRecord.setGmtCreated(new Date());
        return overdueRecord;
    }

    /**=====================信用卡mock end ====================================*/


    /** =====================单车 mock start ================================== */
    private static OverdueRecord shardBikeOverDueRecord() {
        Random random = new Random();

        OverdueRecord overdueRecord = new CreditCardOverdueRecord();
        overdueRecord.setDesc("test" + random.nextInt(100));
        overdueRecord.setGmtCreated(new Date());
        return overdueRecord;
    }

    /** =====================单车 mock end ================================== */

    public static void main(String... args) {
        DataMockUtil.mockData(BizTypeEnum.creditCard);
    }
}
