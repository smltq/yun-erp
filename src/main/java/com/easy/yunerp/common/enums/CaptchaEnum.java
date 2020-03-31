package com.easy.yunerp.common.enums;

/**
 * 验证码类型枚举
 */
public enum CaptchaEnum {
    LOGIN("login"),                     //登录验证码
    FORGET("forget"),                   //密码找回验证码
    AUTHENTICATION("authentication"),   //登录用户密码验证接口,超5次需输入验证码
    SMS("sms");                         //短信验证码

    private final String text;

    CaptchaEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
