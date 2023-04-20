package com.pritam.ayushman.reflection.template;

public abstract class Reports {
    final void prepareReport() {
            openFile();
            addHeaders();
            addRows();
            closeFile();
    }

    abstract public void addHeaders();

    abstract public void addRows();

    public void openFile() {
        System.out.println("Opening file");
    }
    public void closeFile() {
        System.out.println("Closing the file");
    }
}
