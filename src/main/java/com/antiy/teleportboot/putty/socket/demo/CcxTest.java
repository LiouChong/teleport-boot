package com.antiy.teleportboot.putty.socket.demo;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/19 10:14
 */
public class CcxTest {
    public static void main(String[] args) {
        String commandStr="cd /home;cat test.txt";
        Boolean result=ConnectLinuxCommand.connectLinux("192.168.116.115","root","root",commandStr);
        System.out.println(result);
    }
}
