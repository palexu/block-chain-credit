package top.palexu.blockchaincredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:spring/spring-*.xml"})
@SpringBootApplication
@ComponentScan("top.palexu")
public class BlockChainCreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockChainCreditApplication.class, args);
    }
}
