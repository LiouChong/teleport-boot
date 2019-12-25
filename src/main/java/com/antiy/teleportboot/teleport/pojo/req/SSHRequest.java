package com.antiy.teleportboot.teleport.pojo.req;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 13:37
 */
public class SSHRequest {
    private String mode;
    private String authId;
    private Integer accId;
    private String hostId;
    private String protocolType;
    private Integer protocolSubType;
    private String rdpWidth;
    private String rdpHeight;
    private String rdpConsole;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getProtocolSubType() {
        return protocolSubType;
    }

    public void setProtocolSubType(Integer protocolSubType) {
        this.protocolSubType = protocolSubType;
    }

    public String getRdpWidth() {
        return rdpWidth;
    }

    public void setRdpWidth(String rdpWidth) {
        this.rdpWidth = rdpWidth;
    }

    public String getRdpHeight() {
        return rdpHeight;
    }

    public void setRdpHeight(String rdpHeight) {
        this.rdpHeight = rdpHeight;
    }

    public String getRdpConsole() {
        return rdpConsole;
    }

    public void setRdpConsole(String rdpConsole) {
        this.rdpConsole = rdpConsole;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"mode\":\"")
                .append(mode).append('\"');
        sb.append(",\"authId\":\"")
                .append(authId).append('\"');
        sb.append(",\"accId\":\"")
                .append(accId).append('\"');
        sb.append(",\"hostId\":\"")
                .append(hostId).append('\"');
        sb.append(",\"protocolTpe\":\"")
                .append(protocolType).append('\"');
        sb.append(",\"protocolSubType\":\"")
                .append(protocolSubType).append('\"');
        sb.append(",\"rdpWidth\":\"")
                .append(rdpWidth).append('\"');
        sb.append(",\"rdpHeight\":\"")
                .append(rdpHeight).append('\"');
        sb.append(",\"rdpConsole\":\"")
                .append(rdpConsole).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
