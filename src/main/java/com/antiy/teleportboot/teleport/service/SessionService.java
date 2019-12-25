package com.antiy.teleportboot.teleport.service;

import com.alibaba.fastjson.JSONObject;
import com.antiy.teleportboot.sqlite.OpSqliteDB;
import com.antiy.teleportboot.sqlite.ResultUtil;
import com.antiy.teleportboot.teleport.pojo.dto.ACCInfoDto;
import com.antiy.teleportboot.teleport.pojo.req.RPCRequest;
import com.antiy.teleportboot.teleport.pojo.req.SSHRequest;
import com.antiy.teleportboot.teleport.pojo.dto.HostInfoDto;
import com.antiy.teleportboot.teleport.pojo.response.CallBackResponse;
import com.antiy.teleportboot.teleport.util.BaselineHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 13:44
 */
@Service
public class SessionService {
    private static final Long time = System.currentTimeMillis() / 1000;

    private static Map<String, Object> tmpConnInfo;

    @Autowired
    private BaselineHandle baselineHandle;

    public String getSession(SSHRequest sshRequest, HttpServletRequest httpRequest) throws Exception {
        ACCInfoDto accInfo = getAccInfo(sshRequest);

        //TODO: 0xFFFFFFFF
        accInfo.setProtocolFlag(Integer.MAX_VALUE);
        accInfo.setRecordFlag(Integer.MAX_VALUE);
        Map<String, Object> paramMap = getParamMap(accInfo, sshRequest, httpRequest);
        tmpConnInfo = paramMap;

        RPCRequest rpcRequest = new RPCRequest();
        rpcRequest.setMethod("request_session");
        rpcRequest.setParam(Collections.singletonMap("conn_id", time));

        Object o = baselineHandle.callRPC(rpcRequest);
        String s = JSONObject.toJSONString(o);
        System.out.println();

        return s;
    }

    public CallBackResponse rpc(HttpServletRequest request) throws Exception {
        System.out.println("-------------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.size() != 1) {
            throw new Exception("参数异常！");
        }

        RPCRequest rpcRequest = null;
        for (String key : parameterMap.keySet()) {
            System.out.println(key);
            rpcRequest = JSONObject.toJavaObject(JSONObject.parseObject(key), RPCRequest.class);
        }
        System.out.println("rpcRequest为："  + rpcRequest.toString());
        if ("register_core".equals(rpcRequest.getMethod())) {
            registerCore();
        } else if ("get_conn_info".equals(rpcRequest.getMethod())) {
            System.out.println("到达web回调函数，返回值： ");
            System.out.println(JSONObject.toJSONString(this.tmpConnInfo));
        }
        return new CallBackResponse(0, this.tmpConnInfo);
    }

    private CallBackResponse registerCore() throws UnsupportedEncodingException {
        RPCRequest rpcRequest = new RPCRequest();
        rpcRequest.setMethod("set_config");
        rpcRequest.setParam(new HashMap<>());
        Object o = baselineHandle.registerCallRPC(rpcRequest);
        System.out.println("进入register：返回值:" + JSONObject.toJSONString(o));
        return new CallBackResponse(0, new HashMap<>());
    }

    private ACCInfoDto getAccInfo(SSHRequest sshRequest) throws Exception {

        String sql = "select id ,password,pri_key AS priKey,state, host_id AS hostId, " +
                "protocol_type AS protocolType,protocol_port AS protocolPort, auth_type AS authType, username,username_prompt AS usernamePrompt," +
                "password_prompt AS passwordPrompt from tp_acc where id = ?";
        Connection connection = null;
        try {
            // 获取连接
            connection = OpSqliteDB.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 变量赋值
            preparedStatement.setInt(1, sshRequest.getAccId());

            ResultSet resultSet = preparedStatement.executeQuery();

            // 查询结果映射为对象
            List<ACCInfoDto> reflectObject = ResultUtil.getReflectObject(resultSet, ACCInfoDto.class);

            // 只允许数据库中有一个值
            if (reflectObject.size() != 1) {
                throw new Exception("数据库数据有误");
            }

            ACCInfoDto result = reflectObject.get(0);

            // 查询host相关数值。
            getHostInfo(connection, result);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("程序异常！");
        } finally {
            assert connection != null;
            connection.close();
        }
    }

    private void getHostInfo(Connection connection, ACCInfoDto accInfoDto) throws Exception {
        String sql = "select id, name, ip, router_ip as routerIp, router_port as routerPort, state from tp_host where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accInfoDto.getHostId());
        ResultSet resultSet = preparedStatement.executeQuery();

        List<HostInfoDto> hostInfo = ResultUtil.getReflectObject(resultSet, HostInfoDto.class);
        // 只允许数据库中有一个值
        if (hostInfo.size() > 1) {
            throw new Exception("数据库数据有误");
        }
        accInfoDto.setHostInfoDto(hostInfo.get(0));
    }

    private Map<String, Object> getParamMap(ACCInfoDto accInfo, SSHRequest sshRequest, HttpServletRequest httpRequest) {
        HostInfoDto hostInfoDto = accInfo.getHostInfoDto();
        Map<String, Object> connInfo = new HashMap<>();
        connInfo.put("_enc", 1);
        // TODO:格式必须为String
        connInfo.put("client_ip", getIPAddress(httpRequest));
        // TODO:
        connInfo.put("user_id", 1);
        // TODO:String
        connInfo.put("user_username", "admin");
        connInfo.put("host_id", accInfo.getHostId());
        connInfo.put("host_ip", hostInfoDto.getIp());
        if (hostInfoDto.getRouterIp().trim().length() > 0) {
            connInfo.put("conn_ip", hostInfoDto.getRouterIp());
            connInfo.put("conn_port", hostInfoDto.getRouterPort());
        } else {
            connInfo.put("conn_ip", hostInfoDto.getIp());
            connInfo.put("conn_port", accInfo.getProtocolPort());
        }

        connInfo.put("acc_id", sshRequest.getAccId());
        connInfo.put("acc_username", accInfo.getUsername());
        connInfo.put("username_prompt", accInfo.getUsernamePrompt());
        connInfo.put("password_prompt", accInfo.getPasswordPrompt());
        connInfo.put("protocol_flag", accInfo.getProtocolFlag());
        connInfo.put("record_flag", accInfo.getRecordFlag());
        connInfo.put("protocol_type", accInfo.getProtocolType());
        connInfo.put("protocol_sub_type", sshRequest.getProtocolSubType());
        connInfo.put("auth_type", accInfo.getAuthType());
        if (accInfo.getAuthType() == 1) {
            connInfo.put("acc_secret", accInfo.getPassword());
        } else if (accInfo.getAuthType() == 2) {
            connInfo.put("acc_secret", accInfo.getPriKey());
        } else {
            connInfo.put("acc_secret", "");
        }

        return connInfo;
    }

    private String getIPAddress(HttpServletRequest request) {
        try {
            String remoteAddress = "";
            if (request != null) {
                remoteAddress = request.getHeader("X-Forwarded-For");
                if (remoteAddress == null || "".equals(remoteAddress)) {
                    remoteAddress = request.getRemoteAddr();
                }
            }

            remoteAddress = remoteAddress != null && remoteAddress.contains(",")? remoteAddress.split(",")[0]: remoteAddress;
            return remoteAddress;
        } catch (Exception e) {
            return null;
        }
    }
}
