package com.antiy.teleportboot.teleport.pojo.dto;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 14:36
 */
public class HostInfoDto {
    private String id;
    private String name;
    private String ip;
    private String routerIp;
    private Integer routerPort;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRouterIp() {
        return routerIp;
    }

    public void setRouterIp(String routerIp) {
        this.routerIp = routerIp;
    }

    public Integer getRouterPort() {
        return routerPort;
    }

    public void setRouterPort(Integer routerPort) {
        this.routerPort = routerPort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"ip\":\"")
                .append(ip).append('\"');
        sb.append(",\"routerIp\":\"")
                .append(routerIp).append('\"');
        sb.append(",\"routerPort\":\"")
                .append(routerPort).append('\"');
        sb.append(",\"state\":\"")
                .append(state).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
