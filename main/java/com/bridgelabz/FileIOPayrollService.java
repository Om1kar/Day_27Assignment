package com.bridgelabz;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIOPayrollService {
    private final String FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\EmployeePayrollService\\src\\main\\java\\com\\bridgelabzPayrollFile";

    @Override
    public boolean writePayrollData(@NotNull List<EmployeePayrollData> employeeDataList) throws IOException {
        StringBuffer employBuffer = new StringBuffer();
        employeeDataList.forEach(employData -> {
            String employDataString = employData.toString().concat("\n");
            employBuffer.append(employDataString);
        });
        Path path = Files.write(Paths.get(FILE_PATH), employBuffer.toString().getBytes());
        return path != null ? true : false;
    }

    @Override
    public void readPayrollData() throws IOException {
        Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
    }

    @Override
    public long countEntries() throws IOException {
        return Files.lines(new File(FILE_PATH).toPath()).count();
    }

    public List<String> readData() throws IOException {
        List<String> employeePayrollList = new ArrayList<>();
        Files.lines(new File(FILE_PATH).toPath()).map(String::trim)
                .forEach(employeePayrollList::add);
        return employeePayrollList;
    }
}