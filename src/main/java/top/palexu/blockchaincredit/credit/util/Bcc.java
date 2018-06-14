package top.palexu.blockchaincredit.credit.util;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private static final String BINARY = "6060604052341561000f57600080fd5b60008054600160a060020a033316600160a060020a03199091161790556107c78061003b6000396000f3006060604052600436106100615763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166307546172811461006657806311f4a43b1461009557806326f6f6501461016b578063a6c879151461020e575b600080fd5b341561007157600080fd5b61007961022d565b604051600160a060020a03909116815260200160405180910390f35b34156100a057600080fd5b6100f460048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061023c95505050505050565b60405160208082528190810183818151815260200191508051906020019080838360005b83811015610130578082015183820152602001610118565b50505050905090810190601f16801561015d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561017657600080fd5b61020c60048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061048895505050505050565b005b341561021957600080fd5b6100f4600160a060020a0360043516610638565b600054600160a060020a031681565b6102446106ee565b600160a060020a0383166000908152600160208190526040808320909101908490518082805190602001908083835b602083106102925780518252601f199092019160209182019101610273565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020905033600160a060020a03167f5f2600fd3b9b429e9b424b765e43a4c339a9b2dd976da7a408cd8548c3d427038483604051808060200180602001838103835285818151815260200191508051906020019080838360005b8381101561033557808201518382015260200161031d565b50505050905090810190601f1680156103625780820380516001836020036101000a031916815260200191505b508381038252845460026000196101006001841615020190911604808252602090910190859080156103d55780601f106103aa576101008083540402835291602001916103d5565b820191906000526020600020905b8154815290600101906020018083116103b857829003601f168201915b505094505050505060405180910390a2808054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561047a5780601f1061044f5761010080835404028352916020019161047a565b820191906000526020600020905b81548152906001019060200180831161045d57829003601f168201915b505050505091505092915050565b806001600085600160a060020a0316600160a060020a03168152602001908152602001600020600101836040518082805190602001908083835b602083106104e15780518252601f1990920191602091820191016104c2565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020908051610525929160200190610700565b5033600160a060020a03167f5f2600fd3b9b429e9b424b765e43a4c339a9b2dd976da7a408cd8548c3d427038383604051808060200180602001838103835285818151815260200191508051906020019080838360005b8381101561059457808201518382015260200161057c565b50505050905090810190601f1680156105c15780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156105f75780820151838201526020016105df565b50505050905090810190601f1680156106245780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a2505050565b6001602052806000526040600020600091509050806000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106e45780601f106106b9576101008083540402835291602001916106e4565b820191906000526020600020905b8154815290600101906020018083116106c757829003601f168201915b5050505050905081565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061074157805160ff191683800117855561076e565b8280016001018555821561076e579182015b8281111561076e578251825591602001919060010190610753565b5061077a92915061077e565b5090565b61079891905b8082111561077a5760008155600101610784565b905600a165627a7a723058201eb9684c2a38e9a25f58dcdd7319932613e5b9f867f7ddc95aea118871d912ca0029";

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

    public RemoteCall<String> providerMap(String param0) {
        final Function function = new Function("providerMap", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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
