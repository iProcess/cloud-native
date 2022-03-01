package com.naruto.util;

/**
 * ResCode
 * 返回code
 * @author
 * @date 2019/08/26
 */
public enum ResCode {

    /**
     * 成功code
     */
    SUCCESS(0,"SUCCESS"),
    /**
     * 参数错误code
     */
    PARAM_ERROR(400,"PARAM_ERROR"),
    /**
     * 服务端异常code
     */
    SERVER_ERROR(500,"SERVER_ERROR");

    /**
     * 结果code
     */
    private final int code;
    /**
     * 结果code说明
     */
    private final String desc;


    /**
     * 构造方法
     * @param code
     * @param desc
     */
    ResCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
