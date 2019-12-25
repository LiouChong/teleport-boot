package com.antiy.teleportboot.putty.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/19 9:13
 */
public class JavaPortListenner {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            serverSocketChannel.configureBlocking(false);
            // 创建selector
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                if (selector.select(3000) == 0) {
                    continue;
                }
                System.out.println("---------处理请求---------");
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey selectionKey = keyIterator.next();
                    try {
                        if (selectionKey.isAcceptable()) {
                            handleAccept(selectionKey);
                        }
                        if (selectionKey.isReadable()) {
                            handleRead(selectionKey);
                        }
                    } catch (IOException e) {
                        keyIterator.remove();
                        continue;
                    }
                }
                keyIterator.remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        /**
         *      连接请求处理方法
         */
        public static void handleAccept(SelectionKey selectionKey) throws IOException {
            //通过选择器键获取服务器套接字通道，通过accept()方法获取套接字通道连接
            SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
            //设置套接字通道为非阻塞模式
            socketChannel.configureBlocking(false);
            //为套接字通道注册选择器，该选择器为服务器套接字通道的选择器，即选择到该SocketChannel的选择器
            //设置选择器关心请求为读操作，设置数据读取的缓冲器容量为处理器初始化时候的缓冲器容量
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        }

        public static void handleRead(SelectionKey selectionKey) throws IOException {
            //获取套接字通道
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            //获取缓冲器并进行重置,selectionKey.attachment()为获取选择器键的附加对象
            ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
            byteBuffer.clear();

            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            //没有内容则关闭通道
            if (socketChannel.read(byteBuffer) == -1) {
                socketChannel.close();
            } else {
                //将缓冲器转换为读状态
                byteBuffer.flip();
                //将缓冲器中接收到的值按localCharset格式编码保存
                String receivedRequestData = StandardCharsets.UTF_8.newDecoder().decode(byteBuffer).toString();
                System.out.println("接收到客户端的请求数据：" + receivedRequestData);
                //返回响应数据给客户端
                String responseData = "已接收到你的请求数据，响应数据为：(响应数据)";
                System.out.println("准备返回：" + responseData);
                byteBuffer1.put(responseData.getBytes());
                byteBuffer1.flip();
                socketChannel.write(byteBuffer1);

                byteBuffer1.clear();
            }
        }
}
