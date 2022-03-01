package com.naruto.web.channel;

import com.naruto.service.channel.Channel;
import com.naruto.service.channel.ChannelService;
import com.naruto.util.ResCode;
import com.naruto.util.ResUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/channel")
public class ChannelRest {

    @Autowired
    ChannelService channelService;

    @GetMapping("/getChannel")
    public ResUtil getChannel(){
        try {
            List<Channel> channels = channelService.getChannel();
            List<ChannelRes> channelResList = new ArrayList<>();
            for(Channel c: channels){
                ChannelRes channelRes = new ChannelRes();
                BeanUtils.copyProperties(c, channelRes);
                channelResList.add(channelRes);
            }
            return ResUtil.sucMsg(ResCode.SUCCESS.getDesc(), channelResList);
        }catch (Exception e){
            log.error("ChannelRest->getChannel error:", e);
            return ResUtil.serverErrMsg(ResCode.SERVER_ERROR.getDesc());
        }
    }
}
