package com.tk.redpacket.controller;

import com.tk.redpacket.service.IUserRedpacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-9-26.
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {
    @Autowired
    private IUserRedpacketService userRedpacketService;

    @RequestMapping("/grabRedPacket")
    @ResponseBody
    public Map<String,Object>  grabRedPacket(@RequestParam("redPacketId") int redPacketId,@RequestParam("userId") int userId){
        int result = userRedpacketService.grabUserRedPacket(redPacketId,userId);
        boolean flag = result > 0;
        Map<String,Object> retMap = new HashMap<String, Object>();
        retMap.put("success",flag);
        retMap.put("message",flag ? "抢红包成功":"抢红包失败");
        return  retMap;
    }
}
