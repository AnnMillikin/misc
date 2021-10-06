package com.skillsoft.junit;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;

// simple
public class Employee {
    String employeeName;
    String role;
    Double salary;
    String type;
    ArrayList<String> projects;

    public Employee(String employeeName, String role, Double salary, String type) {
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
        this.type = type;
        this.projects = new ArrayList<>();
    }

    public void adjustSalary(double adjAmount) {
        System.out.println("in Employee.adjustSalary method: ");
        System.out.println("Updating salary from: " + salary + " to " + (salary + adjAmount));
        salary += adjAmount;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<String> projects) {
        this.projects = projects;
    }

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

    public void validateLastName() throws Exception {
        if (!this.employeeName.matches("^[a-zA-Z ]*$")) {
            throw new InvalidNameException("Name can only contain upper and lower case alpha");
        }
    }

    public void addProject(String projectName) {
        projects.add(projectName);
    }
}