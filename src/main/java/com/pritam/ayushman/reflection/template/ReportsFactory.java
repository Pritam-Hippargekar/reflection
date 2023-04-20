package com.pritam.ayushman.reflection.template;

import java.util.concurrent.ConcurrentHashMap;

public class ReportsFactory {
    private static final ConcurrentHashMap<String, Reports> CODE_COUNTRY = new ConcurrentHashMap<>();

    static {
        CODE_COUNTRY.put("excel", new Excel());
        CODE_COUNTRY.put("csv", new Csv());
    }

    public static Reports getInstance(final String specialty) {
        return CODE_COUNTRY.get(specialty);
    }
}
