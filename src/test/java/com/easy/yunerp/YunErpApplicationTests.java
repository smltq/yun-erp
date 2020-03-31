package com.easy.yunerp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class YunErpApplicationTests {

    @Value("${spring.jmx.default-domain}")
    private String domain;

    @Test
    public void contextLoads() {

    }

    @Test
    public void versionTest() {
        log.info("当前domain：" + domain);
    }
}