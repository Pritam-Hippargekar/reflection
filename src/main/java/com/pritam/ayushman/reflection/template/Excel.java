package com.pritam.ayushman.reflection.template;

public class Excel extends Reports{
    @Override
    public void addHeaders() {
        System.out.println("Adding excel headers");
    }

    @Override
    public void addRows() {
        System.out.println("Adding excel rows one by one");
    }
}
