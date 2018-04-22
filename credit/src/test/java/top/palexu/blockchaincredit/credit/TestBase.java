package top.palexu.blockchaincredit.credit;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ContextConfiguration(locations = {"classpath:spring-config-test.xml"})
@PropertySource("classpath:application.properties")
public class TestBase {}
