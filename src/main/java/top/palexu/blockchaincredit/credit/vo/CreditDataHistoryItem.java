package top.palexu.blockchaincredit.credit.vo;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class CreditDataHistoryItem {
    /**
     * 三要素
     */
    String provider;
    String subject;
    String bizType;
    /**
     * 指纹
     */
    String print;
    /**
     * 创建时间
     */
    Date gmtCreated;

    //============下面是需要计算的属性

    List<OpPair> opPairList = new LinkedList<>();

    public void addOpPair(String opType, String opContent) {
        opPairList.add(new OpPair(opType, opContent));
    }
    
    public CreditDataHistoryItem(String provider, String subject, String bizType, String print, Date gmtCreated) {
        this.provider = provider;
        this.subject = subject;
        this.bizType = bizType;
        this.print = print;
        this.gmtCreated = gmtCreated;
    }

    @Data
    class OpPair {
        /**
         * 操作类型
         */
        String opType;
        /**
         * 操作的内容
         */
        String opContent;

        public OpPair(String opType, String opContent) {
            this.opType = opType;
            this.opContent = opContent;
        }
    }
}
