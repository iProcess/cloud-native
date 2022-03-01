package com.naruto.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Properties;

/**
 * ClientInfo
 * 客户端来源信息
 * @author
 * @date
 */
@Data
@ToString
public class ClientInfo implements Serializable {


    /**
     * 序列化号
     */
    private static final long serialVersionUID = 1565864103969374991L;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 调用端IP地址
     */
    private String clientIP;

    /**
     * 应用负责人
     */
    private String appLeader;

    /**
     * 调用时间戳
     */
    private Long timestamp;

    public static ClientInfo of(){
        return new ClientInfo();
    }

    public ClientInfo() {
        clientIP = localClientIP;
        appName = localDeployAppName;
        appId = localDeployAppId;
    }

    private static final String localClientIP;

    private static final String localDeployAppId;

    private static final String DEFAULT_NULL_DEPLOY_APP_INFO = "-1";

    private static final String localDeployAppName;

    static {
        localClientIP = NetUtils.getLocalIP();

        Properties props = System.getProperties();
        if (props.getProperty("deploy.app.id") != null) {
            localDeployAppId = props.getProperty("deploy.app.id");
        } else {
            localDeployAppId = DEFAULT_NULL_DEPLOY_APP_INFO;
        }

        if (props.getProperty("deploy.app.name") != null) {
            localDeployAppName = props.getProperty("deploy.app.name");
        } else {
            localDeployAppName = DEFAULT_NULL_DEPLOY_APP_INFO;
        }
    }
}
