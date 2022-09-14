package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PayrollService<EmployeePayrollData> {

    boolean writePayrollData(List<EmployeePayrollData> employeeList) throws IOException;
        void readPayrollData(ArrayList<Object> employeeList) throws IOException;
        long countEntries() throws IOException;

    }

