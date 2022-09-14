package com.bridgelabz;

import java.io.IOException;
import java.util.List;

public class EmployeePayrollService<EmployeePayrollData> {
    static List<EmployeePayrollService> employList;

    public static EmployeePayrollService createEmployeePayrollService(List<EmployeePayrollService> employList) {
        return new EmployeePayrollService(employList);
    }

    public enum IOServices{
        CONSOLE_IO, FILE_IO
    }

    public EmployeePayrollService() {
    }

    /**
     * parameterized constructor
     * @param employList
     */
    private EmployeePayrollService(List<EmployeePayrollData> employList) {
        this.employList = (List<EmployeePayrollService>) employList;
    }
    //    create write method to print data back to console
    public boolean writeEmployPayrollData(IOServices ioServices){
        PayrollService payrollService = getEmployeePayrollObject(ioServices);
        try {
            return payrollService.writePayrollData(employList);
        } catch (IOException e) {
            System.out.println("catch block" + e);
        }
        return false;
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
            payrollService = (PayrollService) new FileIOPayrollService();
        else if(IOServices.CONSOLE_IO.equals(ioServices))
            payrollService = new ConsoleIOPayrollService() {
                @Override
                public void readPayrollData() throws IOException {

                }
            };
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
    }
}
