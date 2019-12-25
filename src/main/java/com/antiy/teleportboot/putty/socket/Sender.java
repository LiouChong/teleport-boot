package com.antiy.teleportboot.putty.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/19 11:09
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        Socket sendSocket = new Socket("192.168.116.115",8090);
        ServerSocket readSocket = new ServerSocket(8080);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(sendSocket.getOutputStream());
        outputStreamWriter.write("你好啊");
        outputStreamWriter.flush();
        outputStreamWriter.close();

        Socket accept = readSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        System.out.println(bufferedReader.readLine());

    }
}
