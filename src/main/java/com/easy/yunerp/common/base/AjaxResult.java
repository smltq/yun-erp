package com.easy.yunerp.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.easy.yunerp.common.constant.RequestConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("接口返回值")
public class AjaxResult<T> {

    AjaxResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    AjaxResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    AjaxResult(String code, String msg, T data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    <E> AjaxResult(String code, String msg, T data, E footer) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.footer = footer;
    }

    @ApiModelProperty("状态码")
    private String code;

    @ApiModelProperty("提示信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 符合条件的数据总数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    /**
     * 底部合计数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object footer;

    /**
     * 未授权
     *
     * @return AjaxResult
     */
    public static AjaxResult unauthorized() {
        return new AjaxResult(RequestConstants.UNAUTHORIZED, RequestConstants.UNAUTHORIZED_MSG);
    }

    /**
     * 未登录
     *
     * @return AjaxResult
     */
    public static AjaxResult notLogin() {
        return new AjaxResult(RequestConstants.NOTLOGIN, RequestConstants.NOT_LOGIN_MSG);
    }

    /**
     * 通用操作成功
     *
     * @param msg 成功提示
     * @return AjaxResult
     */
    public static AjaxResult success(String msg) {
        return new AjaxResult(RequestConstants.SUCCESS, msg);
    }

    /**
     * 通用操作成功
     * @param code 自定义状态码
     * @param msg  成功提示
     * @return
     */
    public static AjaxResult success(String code ,String msg) {
        return new AjaxResult(code, msg);
    }

    /**
     * 通用操作成功
     *
     * @param data 返回数据
     * @return AjaxResult
     */
    public static <T> AjaxResult success(T data) {
        return new AjaxResult(RequestConstants.SUCCESS, RequestConstants.SUCCESS_MSG, data);
    }

    /**
     * 通用操作成功
     *
     * @param msg  成功提示
     * @param data 返回数据
     * @return AjaxResult
     */
    public static <T> AjaxResult success(String msg, T data) {
        return new AjaxResult(RequestConstants.SUCCESS, msg, data);
    }

    /**
     * 通用操作失败
     *
     * @param msg 提示信息
     * @return AjaxResult
     */
    public static AjaxResult fail(String msg) {
        return new AjaxResult(RequestConstants.FAIL, msg);
    }


    /**
     * 通用操作失败
     * @param code 自定义状态码
     * @param msg  提示信息
     * @return
     */
    public static AjaxResult fail(String code,String msg) {
        return new AjaxResult(code, msg);
    }

    public static AjaxResult fail(String msg, Object data) {
        return new AjaxResult(RequestConstants.FAIL, msg, data);
    }

    /**
     * 通用操作失败
     *
     * @return AjaxResult
     */
    public static AjaxResult fail() {
        return new AjaxResult(RequestConstants.FAIL, RequestConstants.FAIL_MSG);
    }

    /**
     * 创建成功
     *
     * @return AjaxResult
     */
    public static AjaxResult created() {
        return new AjaxResult(RequestConstants.CREATED, RequestConstants.SUCCESS_MSG);
    }

    /**
     * 修改成功
     *
     * @return AjaxResult
     */
    public static AjaxResult updated() {
        return new AjaxResult(RequestConstants.UPDATED, RequestConstants.SUCCESS_MSG);
    }

    /**
     * 错误请求（入参或其他客户端引起的问题用这个返回）
     *
     * @return AjaxResult
     */
    public static AjaxResult badRequest() {
        return new AjaxResult(RequestConstants.BAD_REQUEST, RequestConstants.ILLEGAL_PARAMS);
    }

    /**
     * 错误请求（入参或其他客户端引起的问题用这个返回）
     *
     * @param msg 错误信息
     * @return AjaxResult
     */
    public static AjaxResult badRequest(String msg) {
        return new AjaxResult(RequestConstants.BAD_REQUEST, msg);
    }

    /**
     * 成功返回页数据
     *
     * @return AjaxResult
     */
    public static AjaxResult page(IPage<?> page) {
        return new AjaxResult(RequestConstants.SUCCESS, RequestConstants.SUCCESS_MSG, page);
    }

    public static <T, E> AjaxResult list(T data, E footer) {
        return new AjaxResult(RequestConstants.SUCCESS, RequestConstants.SUCCESS_MSG, data, footer);
    }

    public static <T> AjaxResult list(T data, Long total) {
        return new AjaxResult(RequestConstants.SUCCESS, RequestConstants.SUCCESS_MSG, data, total);
    }

    public static <T> AjaxResult list(List<T> data) {
        return new AjaxResult(RequestConstants.SUCCESS, RequestConstants.SUCCESS_MSG, data);
    }
}