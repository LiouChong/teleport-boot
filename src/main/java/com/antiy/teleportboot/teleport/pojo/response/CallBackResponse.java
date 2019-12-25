package com.antiy.teleportboot.teleport.pojo.response;

import com.antiy.teleportboot.teleport.pojo.dto.ACCInfoDto;

import java.util.Map;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/24 9:58
 */
public class CallBackResponse {
    private Integer code;
    private Map<String, Object> data;

    public CallBackResponse(Integer code, Map<String, Object> data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
