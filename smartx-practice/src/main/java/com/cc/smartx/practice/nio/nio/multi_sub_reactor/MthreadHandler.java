package com.cc.smartx.practice.nio.nio.multi_sub_reactor;

import com.cc.smartx.practice.nio.SystemConfig;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MthreadHandler implements Runnable {
    private final SocketChannel channel;
    private final SelectionKey selectionKey;
    private ByteBuffer input = ByteBuffer.allocate(SystemConfig.INPUT_SIZE);
    private ByteBuffer output = ByteBuffer.allocate(SystemConfig.SEND_SIZE);
    private static final int READING = 0, SENDING = 1;
    private int state = READING;
    private ExecutorService pool = Executors.newFixedThreadPool(2);
    private static final int PROCESSING = 3;

    MthreadHandler(Selector selector, SocketChannel c) throws IOException {
        channel = c;
        c.configureBlocking(false);
        selectionKey = channel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    private boolean inputIsComplete() {
        return false;
    }

    private boolean outputIsComplete() {
        return false;
    }

    private void process() {
        return;
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

    private synchronized void read() throws IOException {
        channel.read(input);
        if (inputIsComplete()) {
            state = PROCESSING;
            pool.execute(new Processer());
        }
    }

    private void send() throws IOException {
        channel.write(output);

        if (outputIsComplete()) {
            selectionKey.cancel();
        }
    }

    private synchronized void processAndHandOff() {
        process();
        state = SENDING;
        selectionKey.interestOps(SelectionKey.OP_WRITE);
    }

    class Processer implements Runnable {
        public void run() {
            processAndHandOff();
        }
    }

}