package top.palexu.blockchaincredit;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("top.palexu.blockchaincredit")
@PropertySource("classpath:application.properties")
@MapperScan({"top.palexu.blockchaincredit.report.dao","top.palexu.blockchaincredit.user.dao"})
public class TestBase {}

