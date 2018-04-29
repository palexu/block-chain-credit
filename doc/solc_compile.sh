#!/bin/sh
mkdir target &&
solc Bcc.sol --bin --abi --optimize -o target/ &&
/usr/local/web3j-3.3.1/bin/web3j solidity generate target/Bcc.bin target/Bcc.abi -o ../src/main/java -p top.palexu.blockchaincredit.credit.util &&
echo "rm... target/Bcc.*" &&
rm target/Bcc.* &&
echo "rm -r ... target" &&
rm -r target