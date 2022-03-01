package com.naruto.web.channel;

import com.naruto.service.channel.Channel;
import lombok.Data;

import java.util.List;


@Data
public class ChannelRes {
    /**
     * 渠道名称
     */
    private String label;
    /**
     * 渠道对应的工具名称
     */
    private String value;
    /**
     * 渠道所对应的工具
     */
    private List<Channel> children;
}
