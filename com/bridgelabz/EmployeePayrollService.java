package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private final ArrayList<EmployeePayrollData> employeePayrollDataList;
    private List<EmployeePayrollData> employPayrollDataList;


    public EmployeePayrollService(ArrayList<EmployeePayrollData> employPayrollDataList, List<EmployeePayrollData> employPayrollDataList1) {       //parameterized constructor
        this.employeePayrollDataList =employPayrollDataList;
        this.employPayrollDataList = employPayrollDataList1;
    }
    public static void main(String[] args, List<EmployeePayrollData> employPayrollDataList1) {
        Scanner sc1 = new Scanner(System.in);

        ArrayList<EmployeePayrollData> employPayrollDataList = new ArrayList<>();

        EmployeePayrollService  employPayrollService = new EmployeePayrollService(employPayrollDataList, employPayrollDataList1);

        employPayrollService.readEmployPayrollData(sc1);

        employPayrollService.writeEmployPayrollData();
    }
    //    create write method to print data back to console
    private void writeEmployPayrollData(){
//        print the employee data stored in employPayrollDataList
        System.out.println("Writing EmployPayrollData: " + employPayrollDataList);
    }

    //    method to read the input from user through console
    private void readEmployPayrollData(Scanner sc1){
        System.out.println("Enter your name: ");
        String name = sc1.nextLine();
        System.out.println("Enter your Id: ");
        int id = sc1.nextInt();
        System.out.println("Enter your salary: ");
        double salary = sc1.nextDouble();
        EmployeePayrollData empData = new EmployeePayrollData(id, salary, name);
//    adding all employee data to the arraylist
        employPayrollDataList.add(empData);
    }
}
