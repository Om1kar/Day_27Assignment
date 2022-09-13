package com.bridgelabz;

public class EmployeePayrollData {
    private int id;
    private String name;
    private double salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int id, double salary, String name) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployPayrollData{" + "Id=" + id + ", Name='" + name + '\'' + ", Salary=" + salary + '}';
    }
}
