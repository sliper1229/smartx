package com.cc.smartx.lab;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @Author chenlipeng
 * @Date 2020-09-23
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger atomicData = new AtomicInteger(1);
        System.out.println(atomicData.incrementAndGet());
    }

}
