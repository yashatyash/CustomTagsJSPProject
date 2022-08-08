package com.yash.model;

public class Employee {
    private Integer eId;
    private String eName;
    private double eSalary;
    private int eAge;

    public Employee(Integer eId, String eName, double eSalary, int eAge) {
        this.eId = eId;
        this.eName = eName;
        this.eSalary = eSalary;
        this.eAge = eAge;
    }

    public Employee() {
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }
    public int geteAge() {
        return eAge;
    }

    public void seteAge(int eAge) {
        this.eAge = eAge;
    }
}