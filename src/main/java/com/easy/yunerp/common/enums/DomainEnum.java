package com.easy.yunerp.common.enums;

/**
 * 版本域枚举
 */
public enum DomainEnum {

    DEV("dev"), PROD("prod"), TEST("test");

    private final String text;

    DomainEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
