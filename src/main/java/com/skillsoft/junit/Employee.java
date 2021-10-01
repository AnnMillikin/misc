package com.skillsoft.junit;

public class Employee {
    private String employeeName;
    private String role;

    public Employee(String employeeName, String role) {
        this.employeeName = employeeName;
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
