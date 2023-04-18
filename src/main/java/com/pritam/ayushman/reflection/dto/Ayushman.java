package com.pritam.ayushman.reflection.dto;

import java.time.LocalDate;

public class Ayushman {
    private String name;
    private Integer age;
    private Boolean isIndian;
    private LocalDate dateOfBirth;
    private Long uniqueKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIndian() {
        return isIndian;
    }

    public void setIndian(Boolean indian) {
        isIndian = indian;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(Long uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    @Override
    public String toString() {
        return "Ayushman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isIndian=" + isIndian +
                ", dateOfBirth=" + dateOfBirth +
                ", uniqueKey=" + uniqueKey +
                '}';
    }
}
