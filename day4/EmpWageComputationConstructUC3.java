package com.EmpWageConstruct;
import java.util.Random;


public class Main {
    public static void CheEmpStatus(int num){
        int Wage_HR = 20;
        int Day_HRs = 8;
        int Part_HRs = 8;

        if(num == 1){
            System.out.println("Employee Present");
            System.out.println("DayWage = " + Wage_HR * Day_HRs);
        }
        else if(num == 2){
            System.out.println("Employee Present");
            System.out.println("DayWage with Part Time = " + Wage_HR * (Day_HRs + Part_HRs));
        }

        else{
            System.out.println("Employee Absent");
            System.out.println("DayWage = " +0);
        }


    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random = new Random();
        int r = random.nextInt(3);
        CheEmpStatus(r);

    }
}
