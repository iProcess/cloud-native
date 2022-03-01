package com.naruto.util;

import lombok.Getter;

import java.io.Serializable;

/**
 * ResUtils
 * 后端返回前端统一结果
 * @author
 * @date 2019/08/26
 */
@Getter
public class ResUtil<T> implements Serializable {

    /**
     * 返回码
     */
    private int status;
    /**
     * 返回结果说明
     */
    private String msg;
    /**
     * 返回结果
     */
    private T body;

    /**
     * 构造方法
     * @param status
     */
    private ResUtil(int status) {
        this.status = status;
    }

    /**
     * 构造方法
     * @param status
     * @param body
     */
    private ResUtil(int status, T body) {
        this.status = status;
        this.body = body;
    }

    /**
     * 构造方法
     * @param status
     * @param msg
     * @param body
     */
    private ResUtil(int status, String msg, T body) {
        this.status = status;
        this.msg = msg;
        this.body = body;
    }

    /**
     * 构造方法
     * @param status
     * @param msg
     */
    private ResUtil(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 返回成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> sucMsg(T data) {
        return new ResUtil<>(ResCode.SUCCESS.getCode(), data);
    }

    /**
     * 返回成功
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> sucMsg(String message, T data) {
        return new ResUtil<>(ResCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 返回参数错误
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> paramErrMsg(String message) {
        return new ResUtil<>(ResCode.PARAM_ERROR.getCode(), message);
    }

    /**
     * 返回参数错误
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> paramErrMsg(String message, T data) {
        return new ResUtil<>(ResCode.PARAM_ERROR.getCode(), message, data);
    }

    /**
     * 返回服务端错误
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> serverErrMsg(String message) {
        return new ResUtil<>(ResCode.SERVER_ERROR.getCode(), message);
    }

    /**
     * 返回服务端错误
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResUtil<T> serverErrMsg(String message, T data) {
        return new ResUtil<>(ResCode.SERVER_ERROR.getCode(), message, data);
    }

}
