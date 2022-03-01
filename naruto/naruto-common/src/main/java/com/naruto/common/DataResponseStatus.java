package com.naruto.common;

/**
 * DataResponseStatus
 * 接口通用返回状态
 * @author
 * @date
 */
public enum DataResponseStatus {

    SUCCESS("成功"),
    ERROR("失败");

    /**
     * 描述
     */
    private final String describe;

    /**
     * 构造方法
     * @param describe
     */
    DataResponseStatus(String describe) {
        this.describe = describe;
    }

}
