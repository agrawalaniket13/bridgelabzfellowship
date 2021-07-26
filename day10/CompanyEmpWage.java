package com.Day8;

public class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
    }
}
