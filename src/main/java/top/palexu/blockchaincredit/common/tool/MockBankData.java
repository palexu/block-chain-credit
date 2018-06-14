package top.palexu.blockchaincredit.common.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.model.CreditData;
import top.palexu.blockchaincredit.credit.model.CreditDataContent;
import top.palexu.blockchaincredit.credit.model.CreditDataRow;
import top.palexu.blockchaincredit.credit.model.NaturePerson;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MockBankData {
    @Autowired
    CreditDataStoreService service;

    public void mockBankData() throws IOException {
        File dirFile = new File("/Users/xj/code/worktool/银行/data_icbc");
        //        String fName = "S20180610205709bank5940c4faa6315.txt";
        for (String fName : dirFile.list()) {
            //=============数据=====================================
            CreditDataContent creditDataContent = new CreditDataContent();
            Map<String, List<CreditDataRow>> dataMap = creditDataContent.getData();
            NaturePerson naturePerson = new NaturePerson();
            naturePerson.setIdCard(getIdCard());
            naturePerson.setPhone(getPhone());

            //按行读取文件
            StringBuilder stringBuilder = new StringBuilder();
            Files.lines(Paths.get(dirFile.getAbsolutePath() + "/" + fName)).forEach(stringBuilder::append);
            JSONArray data = JSON.parseObject(stringBuilder.toString()).getJSONArray("data");

            for (Object itemo : data) {
                JSONObject item = (JSONObject) itemo;
                String dataType = item.getJSONObject("dimension").getString("dataType");
                JSONArray array = item.getJSONArray("list");

                if (dataType.contains("balance")) {


                } else if (dataType.contains("basic_info_bank_type_id")) {
                    //                    array.get(0);

                } else if (dataType.contains("person")) {
                    JSONObject np = (JSONObject) array.get(0);
                    naturePerson.setName(np.getString("name"));
                } else if (dataType.contains("detail")) {
                    dataMap.put("支出", new ArrayList<CreditDataRow>());
                    dataMap.put("收入", new ArrayList<CreditDataRow>());
                    for (Object flow : array) {
                        if (flow instanceof JSONObject) {
                            String fundflow = ((JSONObject) flow).getString("fundFlow");
                            CreditDataRow row = new CreditDataRow();
                            row.setGmtCreated(((JSONObject) flow).getDate("tradeTime"));
                            row.setDescription(((JSONObject) flow).getString("tradeDescription"));
                            row.setAddress(((JSONObject) flow).getString("tradeAddress"));
                            row.setValue(((JSONObject) flow).getLongValue("accountBalance"));

                            if ("expense".equals(fundflow.toLowerCase())) {
                                dataMap.get("支出").add(row);
                            } else {
                                dataMap.get("收入").add(row);
                            }
                        }
                    }
                }
            }

            //写入自然人信息
            CreditData creditData = new CreditData();

            creditData.setProvider("DATAHUB");
            creditData.setSubject(naturePerson.getIdCard());
            creditData.setBizType("creditCard");

            creditData.setNaturePerson(naturePerson);
            creditData.addContent(creditDataContent);

            //将数据写入数据库
            log.info("{},{},写入成功", naturePerson.getIdCard(), naturePerson.getPhone());
            service.insertCreditDataContent(creditData);

        }

    }

    private String getPhone() {
        String ts = System.currentTimeMillis() + "";
        return "157000" + ts.substring(ts.length() - 5);
    }

    private String getIdCard() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date randomDate = DateUtils.addDays(new Date(), (int) (System.currentTimeMillis() % 10000));
        String ts = System.currentTimeMillis() + "";
        return "331082" + sdf.format(randomDate) + ts.substring(ts.length() - 4);
    }
}
