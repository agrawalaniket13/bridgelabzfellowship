package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE_NAME = "src/payroll-file.txt";

    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayrollList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return number of entries
     */
    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * @return Employee Payroll Data List
     */
    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath())
                    .map(line->line.trim())
                    .forEach(line->{
                        String data = line.toString();
                        String[] dataArr = data.split(",");
                        for(int i=0;i<dataArr.length;i++){
                            int id = Integer.parseInt(dataArr[i].replaceAll("id =", ""));
                            i++;
                            String name = dataArr[i].replaceAll("name =", "");
                            i++;
                            double salary = Double.parseDouble(dataArr[i].replaceAll("salary =", ""));
                            EmployeePayrollData employeePayrollData = new EmployeePayrollData(id,name,salary);
                            employeePayrollList.add(employeePayrollData);
                        }
                    });
        }catch(IOException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}
