package com.cc.smartx.practice.lambda;

public class Main {

    public static void main(String[] args) {
        ValidateUtil.isTrue(true).throwMessage("exception").throwMessage("exception2");
//        ValidateUtil.isTrue2(true, message -> {
//            throw new RuntimeException(message);
//        }, "exception");
//        ValidateUtil.isTrue3(true, "exception");
    }


}
