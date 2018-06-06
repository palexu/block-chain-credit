package top.palexu.blockchaincredit.credit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import top.palexu.blockchaincredit.credit.util.Bcc;

import java.util.List;

@Service
@Slf4j
public class BccService {

    private static Web3j web3j;
    private static Bcc contract;

    {
        web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));
        Credentials credentials = Credentials.create(
                "d82980be2e0777a5fbbd5ad87f0d741eb8c0058af034d2876bf32f5bba603a6d");
        try {
            contract = Bcc.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String queryPrint(String dataProviderAddress, String subject) {
        try {
            TransactionReceipt query = contract.queryPrint(dataProviderAddress, subject).send();

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

    public boolean upsertPrint(String dataProviderAddress, String subject, String print) {
        try {
            TransactionReceipt query = contract.updatePrint(dataProviderAddress, subject, print).send();
            List<Bcc.PrintEventResponse> responseList = contract.getPrintEvents(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
