package top.palexu.blockchaincredit.credit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import top.palexu.blockchaincredit.common.util.MD5Util;
import top.palexu.blockchaincredit.credit.util.Bcc;

import java.util.List;

@Service
@Slf4j
public class BccService {

    private static Web3j web3j;
    private static Bcc contract;
    private static String rootKey = "cb5a5e78f493d1864369d6feb745d17647a6263cf8b60cb2d8d137e91a88ce15";
    private static String contractAddress = "0x3b72d27f569d5d557f0897bd76c6cb461b37d705";

    {
        web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));
        Credentials credentials = Credentials.create(rootKey);
        try {
            boolean isLoad = true;
            if (isLoad) {
                contract = Bcc.load(contractAddress, web3j, credentials, ManagedTransaction.GAS_PRICE,
                                    Contract.GAS_LIMIT);
            } else {
                contract = Bcc.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String queryPrint(String dataProviderAddress, String subject, String bizType) {
        try {
            TransactionReceipt query = contract.queryPrint(MD5Util.MD5EncodeUtf8(dataProviderAddress),
                                                           subject + bizType).send();

            List<Bcc.PrintEventResponse> responseList = contract.getPrintEvents(query);
            if (responseList.size() == 0) {
                return "";
            }
            return responseList.get(0).printValue;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 返回调用成功时候的交易记录
     *
     * @param dataProviderAddress
     * @param subject
     * @param print
     * @return
     */
    public String upsertPrint(String dataProviderAddress, String subject, String bizType, String print) {
        try {
            TransactionReceipt query = contract.updatePrint(MD5Util.MD5EncodeUtf8(dataProviderAddress),
                                                            subject + bizType, print).send();
            List<Bcc.PrintEventResponse> responseList = contract.getPrintEvents(query);
            if (responseList.size() < 1) {
                return null;
            }
            return responseList.get(0).log.getTransactionHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
