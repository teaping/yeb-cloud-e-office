package com.ztwo.yeb.common.vo;

/**
 * 公共响应类
 *
 * @Author ZTwo
 * @Date 2021/9/11 21:46
 */
public class ResultVO {

    //响应码
    private int code;
    //响应信息
    private String msg;
    //响应数据
    private Object data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    private ResultVO(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    private ResultVO(ResultCode resultCode, Object data) {
        setResultCode(resultCode);
        this.data = data;
    }

    /**
     * 响应成功
     *
     * @param data
     * @return [java.lang.Object]
     */
    public static ResultVO success(Object data) {
        return new ResultVO(ResultCode.SUCCESS, data);
    }

    public static ResultVO success() {
        return new ResultVO(ResultCode.SUCCESS);
    }

    /**
     * 响应失败
     *
     * @param resultCode
     * @param data
     * @return [com.ztwo.yeb.common.vo.ResultCode, java.lang.Object]
     */
    public static ResultVO error(ResultCode resultCode, Object data) {
        return new ResultVO(resultCode, data);
    }

    public static ResultVO error(ResultCode resultCode) {
        return error(resultCode, null);
    }

    /**
     * 设置响应码和响应信息
     *
     * @param resultCode
     * @return [com.ztwo.yeb.common.vo.ResultCode]
     */
    private void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

}
