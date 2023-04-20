package com.pritam.ayushman.reflection.template;

public class TestReports {
    public static void main(String[] args) {
        Reports instance = ReportsFactory.getInstance("csv");
        instance.addHeaders();
    }
}
