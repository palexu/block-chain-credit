pragma solidity ^0.4.21;
contract Bcc {
    address public minter;

    struct DataProvider {
        string name;
        mapping (string => string) printOfData;
    }

    mapping (address => DataProvider) public providerMap;

    function Bcc() public {
        minter = msg.sender;
    }

    function updatePrint(address dataProviderAddress , string subject , string print){
        providerMap[dataProviderAddress].printOfData[subject] = print;
        Print(msg.sender,subject,print);
    }

    function queryPrint(address dataProviderAddress , string subject) returns (string){
        string p = providerMap[dataProviderAddress].printOfData[subject];
        Print(msg.sender,subject,p);
        return p;
    }

    event Print(
        address indexed _from,
        string subject,
        string printValue
    );
}
