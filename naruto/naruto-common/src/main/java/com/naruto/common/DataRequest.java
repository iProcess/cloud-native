package com.naruto.common;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * DataRequest
 * 接口通用请求类
 * @author
 * @date
 */
@Data
@ToString
public class DataRequest<T> implements Serializable {


    /**
     * 序列化号
     */
    private static final long serialVersionUID = 2984724255349186179L;

    /**
     * 客户端来源信息
     */
    private ClientInfo clientInfo;

    /**
     * 承载数据
     */
    @Valid
    private T data;

}
