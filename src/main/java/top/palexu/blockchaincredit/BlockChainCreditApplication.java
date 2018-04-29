package top.palexu.blockchaincredit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:spring/spring-*.xml"})
@SpringBootApplication
@ComponentScan("top.palexu")
@MapperScan({"top.palexu.blockchaincredit.credit.dao", "top.palexu.blockchaincredit.user.dao",
             "top.palexu.blockchaincredit.report.dao"})
public class BlockChainCreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlockChainCreditApplication.class, args);
    }
}
