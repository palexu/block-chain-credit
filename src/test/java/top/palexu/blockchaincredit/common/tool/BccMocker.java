package top.palexu.blockchaincredit.common.tool;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.palexu.blockchaincredit.TestBase;


public class BccMocker extends TestBase {
    @Autowired
    MockBankData mockBankData;

    @Test
    public void mock() throws Exception {
        mockBankData.mockBankData();
    }

}