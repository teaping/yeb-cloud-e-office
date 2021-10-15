package com.ztwo.yeb.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 状态码
 *
 * @Author ZTwo
 * @Date 2021/9/11 21:48
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResultCode {

    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "参数或者语法不对"),
    NO_LOGIN(401, "未登录，禁止访问"),
    CAPTCHA_ERROR(401, "校验码错误"),
    LOGIN_ERROR(401, "登陆失败，用户名或密码无效"),
    UNAUTHORIZED(401, "认证失败，请联系管理员"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "请求资源不存在"),
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    TIME_OUT(408, "请求超时"),
    SERVER_ERROR(500, "服务器内部错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
