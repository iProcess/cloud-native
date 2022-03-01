package com.naruto.common;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * DataResponseError
 * 接口通用错误码
 * @author
 * @date
 */
@Data
@ToString
public class DataResponseError implements java.io.Serializable{

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String describe;

    /**
     * 错误拓展信息
     */
    private Map<String, String> ext;

    /**
     * 构造方法
     */
    public DataResponseError() {
    }

    /**
     * 构造方法
     */
    public DataResponseError(DataErrorCode crmErrorCode) {
        this.code = crmErrorCode.getCode();
        this.describe = crmErrorCode.getDescribe();
    }

    public DataResponseError addErrorInfo(String key, String info){
        if (ext == null) {
            ext = new HashMap<String, String>();
        }
        ext.put(key,info);
        return this;
    }

}
