package com.Day8;

public class EmployeeWageUC1 {
    public static int isFullTime=1;
    private static int empCheck=(int) (Math.floor(Math.random() * 10) % 2);
    public static void employeeWage(){
        if (empCheck==isFullTime)
            System.out.println("Employee is present");
        else
            System.out.println("Employee is absent");
    }
    public static void main(String[ ] args){
        employeeWage();
    }
}
