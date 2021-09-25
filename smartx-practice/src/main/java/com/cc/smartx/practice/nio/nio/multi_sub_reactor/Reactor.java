package com.cc.smartx.practice.nio.nio.multi_sub_reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {

    private Selector[] selectors = new Selector[2];
    private int next = 0;
    private final ServerSocketChannel serverSocket;

    Reactor(int port) throws IOException {
        selectors[0] = Selector.open();
        selectors[1] = Selector.open();

        serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        serverSocket.configureBlocking(false);

        SelectionKey sk = serverSocket.register(selectors[0], SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 2; i++) {
                    selectors[i].select();
                    Set selected = selectors[i].selectedKeys();
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        dispatch((SelectionKey) (it.next()));
                    }
                    selected.clear();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void dispatch(SelectionKey k) {
        Runnable r = (Runnable) (k.attachment());
        if (r != null) {
            r.run();
        }
    }

    class Acceptor {
        public synchronized void run() throws IOException {
            SocketChannel connection = serverSocket.accept();
            if (connection != null) {
                new MthreadHandler(selectors[next], connection);
            }
            if (++next == selectors.length) {
                next = 0;
            }
        }
    }
}
