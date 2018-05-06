package top.palexu.blockchaincredit.report.facade.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.common.BizTypeEnum;
import top.palexu.blockchaincredit.credit.model.CreditDataRecord;
import top.palexu.blockchaincredit.credit.service.CreditDataStoreService;
import top.palexu.blockchaincredit.report.ReportContext;
import top.palexu.blockchaincredit.report.engine.script.Factor;
import top.palexu.blockchaincredit.report.facade.Report;
import top.palexu.blockchaincredit.report.facade.SearchReportJson;
import top.palexu.blockchaincredit.report.facade.SearchReportService;
import top.palexu.blockchaincredit.report.service.ReportService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SearchReportServiceImpl implements SearchReportService {
    @Autowired
    ReportService reportService;

    @Autowired
    CreditDataStoreService creditDataStoreService;

    /**
     * @param subject
     * @return
     */
    @Override
    public String search(String subject) {
        SearchReportJson searchReportJson = new SearchReportJson();

        //用subject找到所有相关数据
        List<CreditDataRecord> recordList = creditDataStoreService.selectAllRecordBySubject(subject);

        //按照bizType不同，选择不同报告生成器进行计算
        //不同bizType的数据和因子不能做融合
        for (CreditDataRecord record : recordList) {
            String bizType = record.getBizType();
            ReportContext context = new ReportContext(subject, record.getProvider(), bizType);
            Report report = new Report();

            Map<String, Factor> factorMap = null;
            //todo 改为在reportservice中处理name 和 desc
            if (BizTypeEnum.creditCard.getValue().equals(bizType)) {
                factorMap = reportService.singleReport(context);
                report.setReportName("信用卡报告");
                report.setDesc("信用卡报告-DATAHUB");
            } else if (BizTypeEnum.sharedBike.getValue().equals(bizType)) {
                factorMap = reportService.singleReport(context);
                report.setReportName("共享单车报告");
                report.setDesc("测试");
            } else {
                log.error("查询报告,没有找到对应的报告处理器,bizType={}", record.getBizType());
            }

            //如果没有结果则跳过
            if (null == factorMap) {
                log.error("查询报告,计算报告结果为空,bizType={}", record.getBizType());
                continue;
            }

            //设置通用属性
            report.getFactors().addAll(factorMap.values());
            report.setBizType(bizType);
            report.setSubject(subject);
            report.setGmtCreated(new Date());

            //组合所有的报告
            searchReportJson.getReports().add(report);
        }

        //返回报告
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(searchReportJson, SerializerFeature.WriteDateUseDateFormat,
                                 SerializerFeature.DisableCircularReferenceDetect);
    }
}
