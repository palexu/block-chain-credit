package top.palexu.blockchaincredit.credit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BccServiceTest {
    BccService service = new BccService();

    @Test
    public void queryPrint() throws Exception {
        log.info(">> result:{}", service.upsertPrint("a", "b", "c"));
        log.info(">> result:{}", service.queryPrint("a", "b"));
    }

}