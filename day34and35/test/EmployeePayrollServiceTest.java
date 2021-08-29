package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.bridgelabz.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollService;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmp = {
                new EmployeePayrollData(1,"Bill",100000.0),
                new EmployeePayrollData(2, "Terisa",300000.0),
                new EmployeePayrollData(3, "Charlie",300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayrollService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        List<EmployeePayrollData> employeeList = employeePayrollService.readData(EmployeePayrollService.IOService.FILE_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        System.out.println(employeeList);
        assertEquals(3, entries);
    }

    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        assertEquals(4, employeePayrollData.size());
    }

    @Test
    public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDatabase() throws EmployeePayrollException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        employeePayrollService.updateEmployeeSalary("Terisa",3000000.00, EmployeePayrollDBService.StatementType.STATEMENT, EmployeePayrollService.NormalisationType.DENORMALISED);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa", EmployeePayrollService.NormalisationType.DENORMALISED);
        assertTrue(result);
    }

    @Test
    public void givenNewSalaryForEmployee_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDatabase() throws EmployeePayrollException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        employeePayrollService.updateEmployeeSalary("Terisa",3000000.00, EmployeePayrollDBService.StatementType.PREPARED_STATEMENT, EmployeePayrollService.NormalisationType.DENORMALISED);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa", EmployeePayrollService.NormalisationType.DENORMALISED);
        assertTrue(result);
    }

    @Test
    public void givenDateRangeForEmployee_WhenRetrievedUsingStatement_ShouldReturnProperData() throws EmployeePayrollException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        List<EmployeePayrollData> employeeDataInGivenDateRange = employeePayrollService.getEmployeesInDateRange("2018-01-03","2019-11-13");
        assertEquals(2, employeeDataInGivenDateRange.size());
    }

    //UC6
    @Test
    public void givenPayrollData_WhenAverageSalaryRetrievedByGender_ShouldReturnProperValue() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        Map<String,Double> averageSalaryByGender  = employeePayrollService.readAverageSalaryByGender(EmployeePayrollService.IOService.DB_IO);
        System.out.println(averageSalaryByGender);
        assertTrue(averageSalaryByGender.get("M").equals(1800000.00)&&
                averageSalaryByGender.get("F").equals(3000000.00));
    }

    @Test
    public void givenNewEmployee_WhenAdded_ShouldSyncWithDB() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.DENORMALISED);
        employeePayrollService.addEmployeeToPayroll("Mark",50000000.00,LocalDate.now(),"M");
        boolean result =  employeePayrollService.checkEmployeePayrollInSyncWithDB("Mark", EmployeePayrollService.NormalisationType.DENORMALISED);
        assertTrue(result);
    }

    //TESTS FOR NORMALISED TABLES
    @Test
    public void givenEmployeePayrollInNormalisedDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.NORMALISED);
        System.out.println(employeePayrollData);
        for(EmployeePayrollData emp : employeePayrollData ) {
            emp.printDepartments();
        }
        assertEquals(3, employeePayrollData.size());
    }

    @Test
    public void givenNewSalaryForEmployeeInNormalisedDB_WhenUpdated_ShouldSyncWithDatabase() throws EmployeePayrollException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(EmployeePayrollService.IOService.DB_IO, EmployeePayrollService.NormalisationType.NORMALISED);
        employeePayrollService.updateEmployeeSalary("Terisa",3000000.00, EmployeePayrollDBService.StatementType.STATEMENT, EmployeePayrollService.NormalisationType.NORMALISED);
        boolean result = employeePayrollService.checkEmployeePayrollInSyncWithDB("Terisa", EmployeePayrollService.NormalisationType.NORMALISED);
        assertTrue(result);
    }

}
