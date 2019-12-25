package com.antiy.teleportboot.teleport.pojo.dto;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 14:17
 */
public class ACCInfoDto {
    private String id;
    private String password;
    private String priKey;
    private String state;
    private Integer hostId;
    private Integer protocolType;
    private Integer protocolPort;
    private Integer authType;
    private String username;
    private String usernamePrompt;
    private String passwordPrompt;
    private Integer recordFlag;
    private Integer protocolFlag;
    private HostInfoDto hostInfoDto;

    public Integer getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(Integer recordFlag) {
        this.recordFlag = recordFlag;
    }

    public Integer getProtocolFlag() {
        return protocolFlag;
    }

    public void setProtocolFlag(Integer protocolFlag) {
        this.protocolFlag = protocolFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPriKey() {
        return priKey;
    }

    public void setPriKey(String priKey) {
        this.priKey = priKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(Integer protocolPort) {
        this.protocolPort = protocolPort;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernamePrompt() {
        return usernamePrompt;
    }

    public void setUsernamePrompt(String usernamePrompt) {
        this.usernamePrompt = usernamePrompt;
    }

    public String getPasswordPrompt() {
        return passwordPrompt;
    }

    public void setPasswordPrompt(String passwordPrompt) {
        this.passwordPrompt = passwordPrompt;
    }

    public HostInfoDto getHostInfoDto() {
        return hostInfoDto;
    }

    public void setHostInfoDto(HostInfoDto hostInfoDto) {
        this.hostInfoDto = hostInfoDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"priKey\":\"")
                .append(priKey).append('\"');
        sb.append(",\"state\":\"")
                .append(state).append('\"');
        sb.append(",\"hostId\":\"")
                .append(hostId).append('\"');
        sb.append(",\"protocolType\":\"")
                .append(protocolType).append('\"');
        sb.append(",\"protocolPort\":\"")
                .append(protocolPort).append('\"');
        sb.append(",\"authType\":\"")
                .append(authType).append('\"');
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"usernamePrompt\":\"")
                .append(usernamePrompt).append('\"');
        sb.append(",\"passwordPrompt\":\"")
                .append(passwordPrompt).append('\"');
        sb.append(",\"recordFlag\":\"")
                .append(recordFlag).append('\"');
        sb.append(",\"protocolFlag\":\"")
                .append(protocolFlag).append('\"');
        sb.append(",\"hostInfoDto\":")
                .append(hostInfoDto);
        sb.append('}');
        return sb.toString();
    }
}
