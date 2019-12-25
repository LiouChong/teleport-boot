package com.antiy.teleportboot.teleport.pojo.dto;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/24 10:13
 */
public class ConnInfo {
    private Integer _enc = 1;
    private String host_id;
    private String host_ip;
    private String client_ip;
    private Integer user_id;
    private String user_username;
    private String conn_ip;
    private Integer conn_port;
    private Integer acc_id;
    private String acc_username;
    private String username_prompt;
    private String password_prompt;
    private Integer protocol_flag;
    private Integer record_flag;
    private Integer protocol_type;
    private Integer protocol_sub_type;
    private Integer auth_type;
    private String acc_secret;

    public Integer get_enc() {
        return _enc;
    }

    public void set_enc(Integer _enc) {
        this._enc = _enc;
    }

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getConn_ip() {
        return conn_ip;
    }

    public void setConn_ip(String conn_ip) {
        this.conn_ip = conn_ip;
    }

    public Integer getConn_port() {
        return conn_port;
    }

    public void setConn_port(Integer conn_port) {
        this.conn_port = conn_port;
    }

    public Integer getAcc_id() {
        return acc_id;
    }

    public String getHost_ip() {
        return host_ip;
    }

    public void setHost_ip(String host_ip) {
        this.host_ip = host_ip;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public String getAcc_username() {
        return acc_username;
    }

    public void setAcc_username(String acc_username) {
        this.acc_username = acc_username;
    }

    public String getUsername_prompt() {
        return username_prompt;
    }

    public void setUsername_prompt(String username_prompt) {
        this.username_prompt = username_prompt;
    }

    public String getPassword_prompt() {
        return password_prompt;
    }

    public void setPassword_prompt(String password_prompt) {
        this.password_prompt = password_prompt;
    }

    public Integer getProtocol_flag() {
        return protocol_flag;
    }

    public void setProtocol_flag(Integer protocol_flag) {
        this.protocol_flag = protocol_flag;
    }

    public Integer getRecord_flag() {
        return record_flag;
    }

    public void setRecord_flag(Integer record_flag) {
        this.record_flag = record_flag;
    }

    public Integer getProtocol_type() {
        return protocol_type;
    }

    public void setProtocol_type(Integer protocol_type) {
        this.protocol_type = protocol_type;
    }

    public Integer getProtocol_sub_type() {
        return protocol_sub_type;
    }

    public void setProtocol_sub_type(Integer protocol_sub_type) {
        this.protocol_sub_type = protocol_sub_type;
    }

    public Integer getAuth_type() {
        return auth_type;
    }

    public void setAuth_type(Integer auth_type) {
        this.auth_type = auth_type;
    }

    public String getAcc_secret() {
        return acc_secret;
    }

    public void setAcc_secret(String acc_secret) {
        this.acc_secret = acc_secret;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"_enc\":")
                .append(_enc);
        sb.append(",\"host_id\":\"")
                .append(host_id).append('\"');
        sb.append(",\"host_ip\":\"")
                .append(host_ip).append('\"');
        sb.append(",\"client_ip\":\"")
                .append(client_ip).append('\"');
        sb.append(",\"user_id\":")
                .append(user_id);
        sb.append(",\"user_username\":\"")
                .append(user_username).append('\"');
        sb.append(",\"conn_ip\":\"")
                .append(conn_ip).append('\"');
        sb.append(",\"conn_port\":")
                .append(conn_port);
        sb.append(",\"acc_id\":")
                .append(acc_id);
        sb.append(",\"acc_username\":\"")
                .append(acc_username).append('\"');
        sb.append(",\"username_prompt\":\"")
                .append(username_prompt).append('\"');
        sb.append(",\"password_prompt\":\"")
                .append(password_prompt).append('\"');
        sb.append(",\"protocol_flag\":")
                .append(protocol_flag);
        sb.append(",\"record_flag\":")
                .append(record_flag);
        sb.append(",\"protocol_type\":")
                .append(protocol_type);
        sb.append(",\"protocol_sub_type\":")
                .append(protocol_sub_type);
        sb.append(",\"auth_type\":")
                .append(auth_type);
        sb.append(",\"acc_secret\":\"")
                .append(acc_secret).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
