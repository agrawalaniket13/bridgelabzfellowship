package com.bridgelabz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    public enum NormalisationType{
        NORMALISED,DENORMALISED
    }

    public List<EmployeePayrollData> employeePayrollList;
    private EmployeePayrollDBService employeePayrollDBService;
    private EmployeePayrollDBServiceNormalised employeePayrollDBServiceNormalised;

    public EmployeePayrollService() {
        employeePayrollDBService = EmployeePayrollDBService.getInstance();
        employeePayrollDBServiceNormalised = EmployeePayrollDBServiceNormalised.getInstance();
    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this();
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeeData(consoleInputReader);
        employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
    }

    /**
     * @param consoleInputReader Read employee data
     */
    public void readEmployeeData(Scanner consoleInputReader) {
        System.out.println("Enter employee ID : ");
        int id = Integer.parseInt(consoleInputReader.nextLine());
        System.out.println("Enter employee name : ");
        String name = consoleInputReader.nextLine();
        System.out.println("Enter employee salary : ");
        double salary = Double.parseDouble(consoleInputReader.nextLine());
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    /**
     * Write payroll data to console
     */
    public void writeEmployeeData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing Employee Payroll Data to Console\n" + employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    /**
     * @param ioService Print Data
     */
    public void printData(IOService ioService) {
        new EmployeePayrollFileIOService().printData();
    }

    /**
     * @param ioService
     * @return number of entries
     */
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    /**
     * @param ioService
     * @return Employee Payroll Data List
     */
    public List<EmployeePayrollData> readData(IOService ioService,NormalisationType normalisationType) {
        if(ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().readData();
        else if(ioService.equals(IOService.DB_IO)) {
            if(normalisationType.equals(NormalisationType.DENORMALISED)) {
                employeePayrollList = employeePayrollDBService.readData();
            }
            else if(normalisationType.equals(NormalisationType.NORMALISED)) {
                employeePayrollList = employeePayrollDBServiceNormalised.readData();
            }
            return employeePayrollList;
        }
        else
            return null;
    }

    /**
     * @param name
     * @param salary
     * @throws EmployeePayrollException
     */
    public void updateEmployeeSalary(String name, double salary, EmployeePayrollDBService.StatementType type, NormalisationType normalisationType) throws EmployeePayrollException {
        int result = 0;
        if(normalisationType.equals(NormalisationType.DENORMALISED)) {
            result = employeePayrollDBService.updateEmployeeData(name,salary,type);
        }
        else if(normalisationType.equals(NormalisationType.NORMALISED)) {
            result = employeePayrollDBServiceNormalised.updateEmployeeData(name,salary,type);
        }
        EmployeePayrollData employeePayrollData = null;
        if(result == 0)
            throw new EmployeePayrollException(EmployeePayrollException.ExceptionType.UPDATE_FAIL, "Update Failed");
        else
            employeePayrollData = this.getEmployeePayrollData(name);
        if(employeePayrollData!=null) {
            employeePayrollData.salary = salary;
        }
    }

    /**
     * @param name
     * @return Employee corresponding to name
     */
    private EmployeePayrollData getEmployeePayrollData(String name) {
        EmployeePayrollData employeePayrollData = this.employeePayrollList.stream()
                .filter(employee->employee.name.equals(name))
                .findFirst()
                .orElse(null);
        return employeePayrollData;
    }

    /**
     * @param name
     * @return true if data is in sync
     */
    public boolean checkEmployeePayrollInSyncWithDB(String name,NormalisationType normalisationType) {
        List<EmployeePayrollData> checkList = null;
        if(normalisationType.equals(NormalisationType.DENORMALISED))
            checkList = employeePayrollDBService.getEmployeePayrollData(name);
        else if(normalisationType.equals(NormalisationType.NORMALISED))
            checkList = employeePayrollDBServiceNormalised.getEmployeePayrollData(name);
        return checkList.get(0).equals(getEmployeePayrollData(name));

    }

    /**
     * @param date1
     * @param date2
     * @return employee list in given date range
     */
    public List<EmployeePayrollData> getEmployeesInDateRange(String date1, String date2) {
        List<EmployeePayrollData> employeesInGivenDateRangeList = employeePayrollDBService.getEmployeesInGivenDateRangeDB(date1,date2);
        return employeesInGivenDateRangeList;
    }

    /**
     * @param ioService
     * @return Employee name and avg salary map
     */
    public Map<String, Double> readAverageSalaryByGender(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            return employeePayrollDBService.getAverageSalaryByGender();
        return null;
    }

    public void addEmployeeToPayroll(String name, double salary, LocalDate startDate, String gender) {
        employeePayrollList.add(employeePayrollDBService.addEmployeeToPayroll(name,salary,startDate,gender));
    }
}
