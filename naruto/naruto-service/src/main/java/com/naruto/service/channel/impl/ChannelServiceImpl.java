package com.naruto.service.channel.impl;

import com.naruto.service.channel.Channel;
import com.naruto.service.channel.ChannelService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChannelServiceImpl implements ChannelService {

    /**
     * 获取渠道和工具名称的对应关系
     * @return
     */
    @Override
    public List<Channel> getChannel(){
        Map<Integer, List<String>> map = getChannelMap();
        List<Channel> channelInfoList = new ArrayList<>();
        for(String c : map.get(0)){
            Channel channel = new Channel();
            channel.setLabel(c);
            channel.setValue(c);
        }
        return channelInfoList;
    }


    private Map<Integer, List<String>> getChannelMap(){
        List<String> all = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        Map<Integer, List<String>> map = new HashMap<>(5);
        map.put(0, all);
        return map;
    }
}
