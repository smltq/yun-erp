package com.easy.yunerp.common.utils;

import com.easy.yunerp.common.constant.UserConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CheckUtil {

    /**
     * 大陆号码或香港号码均可
     *
     * @param phone 手机号
     * @return true | false
     */
    public static boolean isPhoneLegal(String phone) throws PatternSyntaxException {
        return isChinaPhoneLegal(phone) || isHKPhoneLegal(phone);
    }

    /**
     * 判断是否符合大陆手机号格式
     *
     * @param phone 手机号
     * @return true | false
     */
    public static boolean isChinaPhoneLegal(String phone) throws PatternSyntaxException {
        String regExp = UserConstants.CHINA_PHONE_NUMBER_PATTERN;
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 判断是否符合香港手机号格式
     *
     * @param phone 手机号
     * @return true | false
     */
    public static boolean isHKPhoneLegal(String phone) throws PatternSyntaxException {
        String regExp = UserConstants.HONGKONG_PHONE_NUMBER_PATTERN;
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 车牌号码Pattern
     */
    public static final Pattern PLATE_NUMBER_PATTERN = Pattern.compile(UserConstants.CAR_NUMBER_PATTERN);

    /**
     * 车牌号码是否正确
     *
     * @param number 车牌号
     * @return true | false
     */
    public static boolean isPlateNumber(String number) {
        Matcher m = PLATE_NUMBER_PATTERN.matcher(number);
        return m.matches();
    }

    /**
     * 验证邮箱格式是否正确
     */
    public static boolean isEmailLegal(String email)throws PatternSyntaxException{
        String regExp = UserConstants.EMAIL_PATTERN;
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}  