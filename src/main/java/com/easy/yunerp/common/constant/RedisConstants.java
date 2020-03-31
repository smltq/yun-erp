package com.easy.yunerp.common.constant;

/**
 * 缓存Key常量
 */
public class RedisConstants {
    /**
     * 缓存Key前辍
     */
    public static final String PREFIX = "yun-erp:";

    /**
     * 用户密码验证Key
     */
    public static final String AUTHENTICATION = PREFIX + "authentication:";

    /**
     * 用户密码验证Key
     */
    public static final String LOGIN_ERROR = PREFIX + "login_error:";

    /**
     * 类型
     */
    public static final String TYPE = ":type:";

    /**
     * 短信验证key
     */
    public static final String SMS = PREFIX + "sms:";

    /**
     * 短信限制防刷
     */
    public static final String LIMIT = ":limit:";

    /**
     * 记录短信是否发送状态
     */
    public static final String SEND_SUCCESS = ":status:";

    /**
     * 邮箱验证key
     */
    public static final String EMAIL = PREFIX + "email:";

    /**
     * 邮箱激活key
     */
    public static final String ACTIVE = ":active:";

}