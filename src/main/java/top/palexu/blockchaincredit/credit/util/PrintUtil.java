package top.palexu.blockchaincredit.credit.util;


import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.common.util.MD5Util;
import top.palexu.blockchaincredit.credit.model.CreditDataRow;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 数据指纹计算工具类
 *
 * @author xjy
 */
@Service
public class PrintUtil {
    private String make(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg);
        }

        return MD5Util.MD5EncodeUtf8(stringBuilder.toString());
    }

    public String getDataPrint(String provider, String subject, String bizType, Map<String, List<CreditDataRow>> data) {
        //1.排序
        StringBuilder stringBuilder = new StringBuilder();
        data.keySet().stream().sorted(Comparator.comparing(String::hashCode)).forEach(key -> {
            data.get(key).stream().sorted(Comparator.comparing(CreditDataRow::getGmtCreated)).forEach(
                    it -> stringBuilder.append(it.hashCode()));
        });

        //2.输出
        return make(provider, subject, bizType, stringBuilder.toString());
    }

}
