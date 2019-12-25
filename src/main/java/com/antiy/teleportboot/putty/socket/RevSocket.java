package com.antiy.teleportboot.putty.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/19 13:08
 */
public class RevSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9977);
        while (true) {
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            byte[] buf = new byte[1024];
            int line = 0;
            while ((line = is.read(buf)) != -1) {
                System.out.println(new String(buf, 0, line));
                bw.write(line);
                bw.flush();
            }
        }
    }
}
