package com.naruto.common;

/**
 * DataErrorCode
 * 状态码枚举类
 * @author
 * @date:
 */
public enum DataErrorCode {

    /**
     * 参数错误
     */
    ILLEGAL_PARAM_ERROR("400", "请求参数错误"),
    /**
     * 缺失必填参数
     */
    ILLEGAL_PARAM_ERROR_NOTNULL("401", "缺失必填参数"),
    /**
     * 参数非法
     */
    ILLEGAL_PARAM_ERROR_ILLEGAL("402", "参数非法"),

    /**
     * 服务端异常
     */
    SERVER_ERROR("500", "服务端异常"),
    /**
     * 超时异常
     */
    SERVER_ERROR_TIMEOUT("501", "超时异常"),
    /**
     * 未知异常
     */
    SERVER_ERROR_UNKNOW("502", "未知异常"),

    /**
     * 调用方参数异常
     */
    CLIENT_ERROR_NO_AUTHORITY("110","调用方无权限"),

    /**
     * 调用第三方接口异常
     */
    THRID_INTERFACE_ERROR("300", "调用第三方接口异常"),
    ;

    /**
     * 代码
     */
    private final String code;

    /**
     * 状态描述
     */
    private final String describe;

    /**
     * 构造方法
     * @param code
     * @param describe
     */
    DataErrorCode(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

    /**
     * 获取状态码枚举
     * @param code
     * @return
     */
    public static DataErrorCode getErrorCode(String code){
        for (DataErrorCode errorCode : DataErrorCode.values()) {
            if(errorCode.getCode().equals(code)){
                return errorCode;
            }
        }
        return null;

    }

    @Override
    public String toString() {
        return String.format("code:[%s], describe:[%s]. ", this.code, this.describe);
    }

}
