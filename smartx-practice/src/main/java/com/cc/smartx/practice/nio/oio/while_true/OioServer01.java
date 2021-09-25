package com.cc.smartx.practice.nio.oio.while_true;

import com.cc.smartx.practice.nio.SystemConfig;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 这种方法的最大问题是无法并发，效率太低，如果当前的请求没有处理完，那么后面的请求只能被阻塞，服务器的吞吐量太低
 * @Author chenlipeng
 * @Date 2020-09-15
 */
public class OioServer01 {

    public static void main(String[] args) throws Exception {
        while(true){
            ServerSocket ss = new ServerSocket(SystemConfig.SOCKET_SERVER_PORT);
            Socket socket = ss.accept();
            handle(socket);
        }
    }

    private static void handle(Socket socket) throws Exception {
        byte[] buf = new byte[1024];
        socket.getInputStream().read(buf);
    }

}
