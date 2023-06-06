package com.pritam.ayushman.reflection.java8;

public class ambiguous {
    public static void main(String[] args) {
        add(2,3);//ambiguous situation the compiler is not able to figure out which add method need to be called.
    }

    public static void add(int a, long b){
        System.out.println( a + b);
    }
//    public static void add(long a, int b){
//        System.out.println( a + b);
//    }
}
