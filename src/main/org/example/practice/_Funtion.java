package org.example.practice;

import java.util.function.Function;

public class _Funtion {
    public static void main(String[] args) {
        System.out.println(increamentByOneFunction.apply(2));
        System.out.println(increamentByOneFunction.andThen(multiplyBy10Function).apply(5));
    }

    static Function<Integer,Integer> increamentByOneFunction= number -> number +1;
    static Function<Integer, Integer> multiplyBy10Function= number -> number*10;
}
