package top.palexu.blockchaincredit.credit.util;


import top.palexu.blockchaincredit.common.util.MD5Util;

/**
 * 数据指纹计算工具类
 *
 * @author xjy
 */
public class PrintUtil {
    private static String make(String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : args) {
            stringBuilder.append(arg);
        }

        return MD5Util.MD5EncodeUtf8(stringBuilder.toString());
    }

    public static String getDataPrint(String provider, String subject, String bizType, String data) {
        return make(provider, subject, bizType, data);
    }

}
