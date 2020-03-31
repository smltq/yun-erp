package com.easy.yunerp.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
/**
 * maxInactiveIntervalInSeconds为过期时间，单位为秒。（设置31分钟不过期）
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 30)
public class SessionConfig {
}