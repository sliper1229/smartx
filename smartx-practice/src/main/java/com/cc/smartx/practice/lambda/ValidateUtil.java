package com.cc.smartx.practice.lambda;

public class ValidateUtil {

    public static ThrowExceptionFunction isTrue(boolean b) {
        return message -> {
            String message2 = message + b;
            return (Func2) message1 -> System.out.println(message1 + message2);
        };
    }

    public static void isTrue2(boolean b, ThrowExceptionFunction function, String message) {
        if (b) {
            function.throwMessage(message);
        }
    }

    public static void isTrue3(boolean b, String message) {
        if (b) {
            throw new RuntimeException(message);
        }
    }

}
