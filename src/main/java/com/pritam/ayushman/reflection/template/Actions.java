package com.pritam.ayushman.reflection.template;

public enum Actions {
    AYUSHMAN(Constants.EXCEL,"Excel"),RAVAN(Constants.CSV,"Csv");
    private String key;
    private String value;

    Actions(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static class Constants{
         public static final String EXCEL="Excel";
         public static final String CSV = "Csv";
     }
}
