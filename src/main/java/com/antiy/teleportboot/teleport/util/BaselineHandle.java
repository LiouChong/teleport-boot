package com.antiy.teleportboot.teleport.util;

import com.alibaba.fastjson.JSONObject;
import com.antiy.teleportboot.teleport.pojo.req.RPCRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName: BaselineHandle
 * @Auther: chenguoming
 * @Date: 2019/10/16 13:49
 * @Description: 配置请求类
 */
@Component
public class BaselineHandle<T> {
    @Value("${rpc.url}")
    private String url;
    @Value("${register_core.rpc.url}")
    private String registerCoreUrl;
    @Autowired
    private RestTemplate restTemplate;


    /**
     * 请求RPC服务
     *
     * @param rpcRequest
     */
    public Object callRPC(RPCRequest rpcRequest) throws Exception {
        Object actionResponse = postJson(this.url, rpcRequest, new ParameterizedTypeReference<Object>() {});
        return actionResponse;
    }

    public Object registerCallRPC(RPCRequest rpcRequest) throws UnsupportedEncodingException {
        Object o = postJson(this.registerCoreUrl, rpcRequest, new ParameterizedTypeReference<Object>() {
        });
        return o;
    }


    /**
     * 参数为json格式的post请求
     *
     * @param url     url
     * @param request 请求参数
     * @return
     */
    private T postJson(String url, Object request, ParameterizedTypeReference parameterizedTypeReference) throws UnsupportedEncodingException {
//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
//        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity(JSONObject.toJSONString(request).getBytes("UTF-8"));
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, parameterizedTypeReference);
        return responseEntity.getBody();
    }

}
