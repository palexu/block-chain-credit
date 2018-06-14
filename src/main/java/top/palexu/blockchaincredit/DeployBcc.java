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
        String privateKey = "cb5a5e78f493d1864369d6feb745d17647a6263cf8b60cb2d8d137e91a88ce15";

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
