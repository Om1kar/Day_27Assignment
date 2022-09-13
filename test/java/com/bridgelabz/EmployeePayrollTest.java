package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollTest {
    public class EmployPayrollTest {
        @Test
        public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
            EmployeePayrollData employee1 = new EmployeePayrollData(1, "Jeff", 10000.0);
            EmployeePayrollData employee2 = new EmployeePayrollData(2, "Jack", 20000.0);
            EmployeePayrollData employee3 = new EmployeePayrollData(3, "John", 30000.0);
            List<EmployeePayrollData> employPayrollDataList = new ArrayList<>();
            employPayrollDataList.add(employee1);
            employPayrollDataList.add(employee2);
            employPayrollDataList.add(employee3);
            EmployeePayrollService employPayrollService = new EmployeePayrollService(employPayrollDataList);
            employPayrollService.writeEmployeePayrollData(EmployeePayrollService.IOServices.FILE_IO);
            employPayrollService.readEmployeePayrollData(EmployeePayrollService.IOServices.FILE_IO);
            long count = employPayrollService.countEntries(EmployeePayrollService.IOServices.FILE_IO);
            Assertions.assertEquals(3, count);

        }
    }
}
