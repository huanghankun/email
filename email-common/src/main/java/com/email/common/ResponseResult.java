
package com.email.common;

import com.alibaba.fastjson.JSON;

public class ResponseResult<T> {
    public static final String SUCCESS_CODE = "0000";
    public static final String EXCEPTION_CODE = "0500";
    public static final String FAIL_CODE = "0100";
    public static final String AUTH_FAIL_CODE = "0403";
    public static final String LOGIN_FAIL_CODE = "0402";
    public static final String LOGIN_REQUIRE_CODE = "0401";
    private String code;
    private String msg;
    private T data;

    public ResponseResult() {
        this.code = "0000";
    }

    public ResponseResult(T data) {
        this.code = "0000";
        this.setData(data);
    }

    public ResponseResult(String code, String msg) {
        this(code, msg, null);
    }

    public ResponseResult(String code, String msg, T data) {
        this(data);
        this.setCode(code);
        this.setMsg(msg);
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult<T> createSuccessResult(String msg, T data) {
        return new ResponseResult("0000", msg, data);
    }

    public static <T> ResponseResult<T> createFailResult(String msg, T data) {
        return new ResponseResult("0100", msg, data);
    }

    public static <T> ResponseResult<T> createExceptionResult(String msg, T data) {
        return new ResponseResult("0500", msg, data);
    }

    public static <T> ResponseResult<T> createAuthFailResult(T data) {
        return new ResponseResult("0403", "无权限", data);
    }

    public static <T> ResponseResult<T> createLoginFailResult(T data) {
        return new ResponseResult("0403", "登录失败", data);
    }

    public static <T> ResponseResult<T> createLoginRequireResult(T data) {
        return new ResponseResult("0403", "未登录", data);
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
