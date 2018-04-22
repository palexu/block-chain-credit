pragma solidity ^0.4.21;
contract Bcc {

    address public minter;

    // data
    struct DataProvider {
        string name;
        //subject => print
        mapping (string => string) printOfData;
    }

    mapping (address => DataProvider) public providerMap;

    // functions

    function Bcc() public {
        minter = msg.sender;
    }


    // ==== provider ====


    //添加数据提供者 admin
    function addDataProvider(address dataProviderAddress , string dataProviderName){
        providerMap[dataProviderAddress] = DataProvider(dataProviderName);
    }

    //删除数据提供者 admin
    function deleteDataProvider(address dataProviderAddress){
        //todo
    }


    // ==== print ====

    // 直接增加/修改subject对应的指纹
    // 历史的print应该是记录在了区块链上的
    function updatePrint(address dataProviderAddress , string subject , string print){
        providerMap[dataProviderAddress].printOfData[subject] = print;
    }

    //查询
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