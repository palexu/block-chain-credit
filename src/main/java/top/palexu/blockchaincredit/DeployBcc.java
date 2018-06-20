package top.palexu.blockchaincredit;

import lombok.extern.slf4j.Slf4j;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import top.palexu.blockchaincredit.credit.util.Bcc;

/**
 * @author xjy
 */
@Slf4j
public class DeployBcc {
    public static void main(String... args) {
        String privateKey = "cd1c0307ca72ef19b8cd5870b74064922d4905bcfb9048ce4d05ae2938ac7a07";

        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));

        Credentials credentials = Credentials.create(privateKey);
        Bcc contract;
        try {
            contract = Bcc.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
            log.info("智能合约部署成功,{}", contract.getContractAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
