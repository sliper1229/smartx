package com.cc.smartx.practice.nio.oio.connection_per_thread;

import com.cc.smartx.practice.nio.SystemConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OioServer02 implements Runnable {
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(SystemConfig.SOCKET_SERVER_PORT);
            while (!Thread.interrupted()) {
                Socket socket = ss.accept();
                new Thread(new Handler(socket)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static class Handler implements Runnable {
        final Socket socket;

        Handler(Socket s) {
            socket = s;
        }

        public void run() {
            try {
                byte[] input = new byte[SystemConfig.INPUT_SIZE];
                socket.getInputStream().read(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new OioServer02()).start();
    }
}