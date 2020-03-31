package com.easy.yunerp.common.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * 控制器基类
 **/
@Slf4j
public class BaseController {

    @Value("${spring.jmx.default-domain}")
    protected String domain;
}
