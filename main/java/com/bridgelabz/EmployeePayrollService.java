package com.bridgelabz;

import java.io.IOException;
import java.util.List;

public class EmployeePayrollService{
    static List<EmployePayrollData> employList;

    public enum IOServices{
        CONSOLE_IO, FILE_IO
    }

    /**
     *Default constructor
     */
    public EmployeePayrollService() {
    }

    /**
     * parameterized constructor
     * @param employList
     */
    public EmployeePayrollService(List<EmployeePayrollData> employList) {
        EmployeePayrollService.employList =employList;
    }
    //    create write method to print data back to console
    public void writeEmployPayrollData(IOServices ioServices){
        PayrollService payrollService = getEmployeePayrollObject(ioServices);
        try {
            payrollService.writePayrollData(employList);
        } catch (IOException e) {
            System.out.println("catch block" + e);
        }
    }
    public void readEmployPayrollData(IOServices ioServices) {
        PayrollService payrollService = getEmployeePayrollObject(ioServices);
        try {
            payrollService.readPayrollData();
        } catch (IOException e) {
            System.out.println("catch block" + e);
        }
    }
    public long countEntries(IOServices ioServices) {
        PayrollService payrollService = getEmployeePayrollObject(ioServices);
        try {
            return payrollService.countEntries();
        } catch (IOException e) {
            System.out.println("catch block" + e);
        }
        return 0;
    }
    private static PayrollService getEmployeePayrollObject(IOServices ioServices){
        PayrollService payrollService = null;
        if(IOServices.FILE_IO.equals(ioServices))
            payrollService = new FileIOPayrollService();
        else if(IOServices.CONSOLE_IO.equals(ioServices))
            payrollService = new ConsoleIOPayrollService();
        return payrollService;
    }

    //    method to read the input from user through console
    public static void main(String[] args) {
        EmployeePayrollService employPayrollService = new EmployeePayrollService();
        employPayrollService.readEmployPayrollData(IOServices.CONSOLE_IO);
        employPayrollService.writeEmployPayrollData(IOServices.CONSOLE_IO);
        long count= employPayrollService.countEntries(IOServices.CONSOLE_IO);
//        Show FileIO count no of entries.
        System.out.println(count);
        FileIOPayrollService fileIOPayrollService = new FileIOPayrollService();
        try {
            List<String> list= fileIOPayrollService.readData();
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}