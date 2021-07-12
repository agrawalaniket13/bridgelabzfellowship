package com.EmpWageConstruct;
import java.util.Random;

public class Main {
    public static void CheEmpStatus(int num){
        if(num == 1)
            System.out.println("Employee Present");
        else
            System.out.println("Employee Absent");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random = new Random();
        int r = random.nextInt(2);
        CheEmpStatus(r);
    }
}
