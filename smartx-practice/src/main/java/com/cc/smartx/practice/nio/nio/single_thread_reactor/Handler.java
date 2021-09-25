package com.cc.smartx.practice.nio.nio.single_thread_reactor;

import com.cc.smartx.practice.nio.SystemConfig;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
    private final SocketChannel channel;
    private final SelectionKey sk;
    private ByteBuffer input = ByteBuffer.allocate(SystemConfig.INPUT_SIZE);
    private ByteBuffer output = ByteBuffer.allocate(SystemConfig.SEND_SIZE);
    private static final int READING = 0, SENDING = 1;
    private int state = READING;

    Handler(Selector selector, SocketChannel c) throws IOException {
        channel = c;
        c.configureBlocking(false);
        sk = channel.register(selector, 0);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    private boolean inputIsComplete() {
        return false;
    }

    private boolean outputIsComplete() {
        return false;
    }

    private void process() {

    }

    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void read() throws IOException {
        channel.read(input);
        if (inputIsComplete()) {

            process();

            state = SENDING;

            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void send() throws IOException {
        channel.write(output);

        if (outputIsComplete()) {
            sk.cancel();
        }
    }
}
