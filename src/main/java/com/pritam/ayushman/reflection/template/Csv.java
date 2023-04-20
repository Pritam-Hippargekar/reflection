package com.pritam.ayushman.reflection.template;

public class Csv extends Reports{
    @Override
    public void addHeaders() {
        System.out.println("Adding csv headers");
    }

    @Override
    public void addRows() {
        System.out.println("Adding csv rows one by one");
    }
}
