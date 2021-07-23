package com.Day8;

public class EmployeeWageUC4 {
    public static final int IS_PART_TIME =1;
    public static final int IS_FULL_TIME =2;
    public static final int EMP_RATE_PER_HOUR =20;
    public static int empHrs=0;
    public static int empWage=0;

    private static int empCheck=(int) (Math.floor(Math.random() * 10) % 3);

    public static void employeeWage(){
        switch (empCheck){
            case IS_PART_TIME:
                empHrs = 4;
                break;
            case IS_FULL_TIME:
                empHrs = 8;
                break;
            default:
                empHrs = 0;
        }
        empWage=empHrs*EMP_RATE_PER_HOUR;
        System.out.println("Employee wages is:" + empWage);
    }
    public static void main(String[ ] args){
        employeeWage();
    }
}
