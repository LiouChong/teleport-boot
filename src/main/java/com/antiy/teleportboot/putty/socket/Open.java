package com.antiy.teleportboot.putty.socket;

import java.io.IOException;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/19 10:35
 */
public class Open {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("E:\\VirtualMarchine\\putty\\putty.exe -ssh -pw root -P 22 -l root 192.168.116.115");
    }
}
