package com.Day8;

public class EmployeeWageUC3 {
    public static int IS_PART_TIME =1;
    public static int IS_FULL_TIME =2;
    public static int EMP_RATE_PER_HOUR =20;
    public static int empHrs=0;
    public static int empWage=0;

    private static double empCheck=(double) (Math.floor(Math.random() * 10) % 3);

    public static void employeeWage(){
        if (empCheck==IS_PART_TIME)
            empHrs=4;
        else if (empCheck==IS_FULL_TIME)
            empHrs = 8;
        else
            empHrs=0;
        empWage = empHrs * EMP_RATE_PER_HOUR;
        System.out.printf("Employee Wage is"+empWage);
    }
    public static void main(String[ ] args){
        employeeWage();
    }
}
