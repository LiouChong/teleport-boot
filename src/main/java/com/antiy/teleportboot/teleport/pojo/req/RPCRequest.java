package com.antiy.teleportboot.teleport.pojo.req;

import java.util.Map;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 15:53
 */
public class RPCRequest {
    private String method;
    private Map<String, Object> param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"method\":\"")
                .append(method).append('\"');
        sb.append(",\"param\":")
                .append(param);
        sb.append('}');
        return sb.toString();
    }
}
