package top.palexu.blockchaincredit.credit;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import top.palexu.blockchaincredit.credit.util.Bcc;

public class Test {
    public static void main(String... args) {
        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));
        Credentials credentials = Credentials.create(
                "09dd2aefba5d9868a0194f3940e2648b431545ea9533ad18e04f883b1b647f26");
        try {
            Bcc contract = Bcc.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
            TransactionReceipt transactionReceipt = contract.updatePrint("704961", "a", "print").send();
            TransactionReceipt query = contract.queryPrint("704961","a").send();
            for (Bcc.PrintEventResponse eventResponse : contract.getPrintEvents(query)) {
                System.out.println(
                        eventResponse._from + "\n" + eventResponse.subject + "\n" + eventResponse.printValue + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
