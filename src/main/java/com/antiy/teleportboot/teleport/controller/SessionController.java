package com.antiy.teleportboot.teleport.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.antiy.teleportboot.teleport.pojo.req.RPCRequest;
import com.antiy.teleportboot.teleport.pojo.req.SSHRequest;
import com.antiy.teleportboot.teleport.pojo.dto.ACCInfoDto;
import com.antiy.teleportboot.teleport.pojo.response.CallBackResponse;
import com.antiy.teleportboot.teleport.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 13:38
 */
@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/ops/get-session-id", method = RequestMethod.POST)
    public String getSession(@RequestBody SSHRequest sshRequest, HttpServletRequest request) throws Exception {
        return sessionService.getSession(sshRequest, request);
    }

    @RequestMapping("/rpc")
    public CallBackResponse serverCallBack(HttpServletRequest httpServletRequest) throws Exception {
        return sessionService.rpc(httpServletRequest);
    }

}
