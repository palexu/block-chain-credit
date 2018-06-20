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
    private static String rootKey = "cd1c0307ca72ef19b8cd5870b74064922d4905bcfb9048ce4d05ae2938ac7a07";
    private static String contractAddress = "0xa75f9e8a5fc676edc83efc0c2742420cf48d6787";

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
