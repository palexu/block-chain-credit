package top.palexu.blockchaincredit.credit.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.NaturePerson;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardData;
import top.palexu.blockchaincredit.credit.model.detail.creditCard.CreditCardOverdueRecord;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 用于模拟数据
 *
 * @author xjy
 */
@Component
public class DataMockUtil {
    public static Logger logger = LoggerFactory.getLogger(DataMockUtil.class);


    public static final String PROVIDER = "DATAHUB";
    public static final String SUBJECT = "TEST01";
    public static final BizTypeEnum BIZ_TYPE = BizTypeEnum.creditCard;

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

        //设置主体三要素
        setProSubBiz(creditData);

        //设置数据内容
        switch (bizTypeEnum) {
            case creditCard:
                creditData.setData(JSON.toJSONString(mockCreditCard()));
                break;
            default:
                break;
        }

        logger.info("{}", creditData);
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
        setProSubBiz(creditData);

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
        List<CreditCardOverdueRecord> overdueRecords = creditCardData.getCreditCardOverdueRecords();
        for (int i = 0; i < 10; i++) {
            overdueRecords.add(mockOverDueRecord());
        }

        //...
        return creditCardData;
    }

    /**
     * 设置主体三要素
     *
     * @param creditData
     */
    private static void setProSubBiz(CreditData creditData) {
        creditData.setProvider(PROVIDER);
        creditData.setSubject(SUBJECT);
        creditData.setBizType(BIZ_TYPE.value);
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
        overdueRecord.setGmtCreate(new Date());
        return overdueRecord;
    }

    public static void main(String... args) {
        DataMockUtil.mockData(BizTypeEnum.creditCard);
    }
}
