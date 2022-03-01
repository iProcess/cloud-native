package com.naruto.service.channel;


import java.util.List;

public interface ChannelService {
    /**
     * 获取渠道和工具名称的对应关系
     * @return
     */
    List<Channel> getChannel();
}
