package com.bridgelabz;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ConsoleIOPayrollService implements PayrollService {

    private ArrayList<Object> employeeList;

    @Override
    public boolean writePayrollData(List employList) {
        System.out.println("Given Employee Data is : " + employList);
        return false;
    }

    public <EmployeePayrollData> void readPayrollData(ArrayList<Object> employeeList) {
        this.employeeList = employeeList;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc1.nextLine();
        System.out.println("Enter your Id: ");
        int id = sc1.nextInt();
        System.out.println("Enter your salary: ");
        double salary = sc1.nextDouble();
        employeeList = new ArrayList<>();
        EmployeePayrollData empData;
        empData = new EmployeePayrollData(id, name, salary);
//    adding all employee data to the arraylist
        employeeList.add(empData);
    }

    @Override
    public long countEntries() throws IOException {
        return new FileIOPayrollService().countEntries();
    }
}
