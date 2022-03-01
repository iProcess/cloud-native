package com.naruto.common;


import lombok.Data;

/**
 * DataResponse
 * 通用接口返回类
 * @author
 * @date
 */
@Data
public class DataResponse<T> implements java.io.Serializable{

    /**
     * 接口通用返回状态
     */
    private DataResponseStatus crmResponseStatus;

    /**
     * 返回结果
     */
    private T data;

    /**
     * 接口通用错误码
     */
    private DataResponseError crmResponseError;

    public static <T> DataResponse<T> success(T t){
        DataResponse<T> response = new DataResponse<T>();
        response.setCrmResponseStatus(DataResponseStatus.SUCCESS);
        response.setData(t);
        return response;
    }

    public static <T> DataResponse<T> error(T t){
        DataResponse<T> response = new DataResponse<T>();
        response.setCrmResponseStatus(DataResponseStatus.ERROR);
        return response;
    }

}
