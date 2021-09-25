package com.cc.smartx.practice.nio.nio.single_thread_reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);

        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        sk.attach(new Acceptor());
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) it.next();
                    dispatch(selectionKey);
                }

                selectionKeys.clear();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable r = (Runnable) (selectionKey.attachment());
        if (r != null) {
            new Thread(r).start();
        }
    }

    class Acceptor implements Runnable {
        public void run() {
            try {
                SocketChannel channel = serverSocket.accept();
                if (channel != null) {
                    new Handler(selector, channel);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}