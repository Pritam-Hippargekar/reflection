package com.pritam.ayushman.reflection.work;

import java.math.BigDecimal;

public class Process {

    private Department department;
    private String message;

    private static final String variable = "Ayushman ravan.";

    private Process(Department department,String message) {
        this.department = department;
        this.message = message;
    }

    private Employee launchProcess(Employee employee, BigDecimal salary){
        employee.setDeptId(this.department.getDeptId());
        employee.setSalary(salary);
        return employee;
    }

    private static void stopProcess(Integer type){
         System.out.println(variable +" "+type);
    }
}
