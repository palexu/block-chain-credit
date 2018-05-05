package top.palexu.blockchaincredit.credit.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * 征信数据存储 mongo
 * todo 需要细化在mongo中的操作
 *
 * @author xjy
 */
@Data
public class CreditData extends CreditDataRecord {

    /**
     * 自然人三要素
     */
    NaturePerson naturePerson;

    /**
     * 所有数据的历史记录，目前每次都是全量保存
     * Long：version版本，从0开始，每次增加1
     */
    List<CreditDataContent> datas = new LinkedList<>();

    /**
     * 获取最新的content
     *
     * @return
     */
    public CreditDataContent getLatestContent() {
        if (datas.size() == 0) {
            return null;
        }
        if (datas.size() == 1) {
            return datas.get(0);
        }

        CreditDataContent result = datas.get(0);
        for (CreditDataContent content : datas) {
            if (content.getVersion() > result.getVersion()) {
                result = content;
            }
        }
        return result;
    }


    public void addContent(CreditDataContent content) {
        this.datas.add(content);
    }

}
