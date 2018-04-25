package top.palexu.blockchaincredit.credit.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Bcc extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60008054600160a060020a033316600160a060020a03199091161790556107918061003b6000396000f3006060604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166307546172811461007c57806311f4a43b146100ab57806326f6f650146101815780636682f41e14610224578063a6c8791514610283578063e3d166e7146102a2575b600080fd5b341561008757600080fd5b61008f6102c1565b604051600160a060020a03909116815260200160405180910390f35b34156100b657600080fd5b61010a60048035600160a060020a03169060446024803590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506102d095505050505050565b60405160208082528190810183818151815260200191508051906020019080838360005b8381101561014657808201518382015260200161012e565b50505050905090810190601f1680156101735780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561018c57600080fd5b61022260048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061051c95505050505050565b005b341561022f57600080fd5b61022260048035600160a060020a03169060446024803590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506105bf95505050505050565b341561028e57600080fd5b61010a600160a060020a03600435166105ff565b34156102ad57600080fd5b610222600160a060020a03600435166106b5565b600054600160a060020a031681565b6102d86106b8565b600160a060020a0383166000908152600160208190526040808320909101908490518082805190602001908083835b602083106103265780518252601f199092019160209182019101610307565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020905033600160a060020a03167f5f2600fd3b9b429e9b424b765e43a4c339a9b2dd976da7a408cd8548c3d427038483604051808060200180602001838103835285818151815260200191508051906020019080838360005b838110156103c95780820151838201526020016103b1565b50505050905090810190601f1680156103f65780820380516001836020036101000a031916815260200191505b508381038252845460026000196101006001841615020190911604808252602090910190859080156104695780601f1061043e57610100808354040283529160200191610469565b820191906000526020600020905b81548152906001019060200180831161044c57829003601f168201915b505094505050505060405180910390a2808054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561050e5780601f106104e35761010080835404028352916020019161050e565b820191906000526020600020905b8154815290600101906020018083116104f157829003601f168201915b505050505091505092915050565b806001600085600160a060020a0316600160a060020a03168152602001908152602001600020600101836040518082805190602001908083835b602083106105755780518252601f199092019160209182019101610556565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390209080516105b99291602001906106ca565b50505050565b60206040519081016040908152828252600160a060020a03841660009081526001602052208151819080516105f89291602001906106ca565b5050505050565b6001602052806000526040600020600091509050806000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106ab5780601f10610680576101008083540402835291602001916106ab565b820191906000526020600020905b81548152906001019060200180831161068e57829003601f168201915b5050505050905081565b50565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061070b57805160ff1916838001178555610738565b82800160010185558215610738579182015b8281111561073857825182559160200191906001019061071d565b50610744929150610748565b5090565b61076291905b80821115610744576000815560010161074e565b905600a165627a7a72305820bf5c1729902be41e4a5a2d77d1c166f7204c76c74ab9b9628bec12de4097202f0029";

    protected Bcc(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bcc(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<PrintEventResponse> getPrintEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Print", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<PrintEventResponse> responses = new ArrayList<PrintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PrintEventResponse typedResponse = new PrintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.printValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PrintEventResponse> printEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Print", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PrintEventResponse>() {
            @Override
            public PrintEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                PrintEventResponse typedResponse = new PrintEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.subject = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.printValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> minter() {
        final Function function = new Function("minter", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> queryPrint(String dataProviderAddress, String subject) {
        final Function function = new Function(
                "queryPrint", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dataProviderAddress), 
                new org.web3j.abi.datatypes.Utf8String(subject)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updatePrint(String dataProviderAddress, String subject, String print) {
        final Function function = new Function(
                "updatePrint", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dataProviderAddress), 
                new org.web3j.abi.datatypes.Utf8String(subject), 
                new org.web3j.abi.datatypes.Utf8String(print)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addDataProvider(String dataProviderAddress, String dataProviderName) {
        final Function function = new Function(
                "addDataProvider", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dataProviderAddress), 
                new org.web3j.abi.datatypes.Utf8String(dataProviderName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> providerMap(String param0) {
        final Function function = new Function("providerMap", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> deleteDataProvider(String dataProviderAddress) {
        final Function function = new Function(
                "deleteDataProvider", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dataProviderAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Bcc> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bcc.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bcc> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bcc.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Bcc load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bcc(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Bcc load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bcc(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class PrintEventResponse {
        public Log log;

        public String _from;

        public String subject;

        public String printValue;
    }
}
