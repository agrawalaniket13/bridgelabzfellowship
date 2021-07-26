package com.Day8;

public class EmpWageBuilderArray {
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private int numOfCompany = 0;
    private CompanyEmpWage[ ] companyEmpWageArray;

    public EmpWageBuilderArray(){
        companyEmpWageArray = new CompanyEmpWage[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){
        companyEmpWageArray[numOfCompany] = new  CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);

        numOfCompany++;
    }

    private void computeEmpWage(){
        for (int i = 0; i < numOfCompany; i++){
            int totalEmpWage=this.computeEmpWage(companyEmpWageArray[i]);
            System.out.println("Total Emp Wage is "+companyEmpWageArray[i].company+"is"+totalEmpWage);
        }
    }
    private int computeEmpWage(CompanyEmpWage companyEmpWage){
        //variable
        int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
        //computation
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays <= companyEmpWage.numOfWorkingDays){
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
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
            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays + "Emp hrs:" +empHrs);
        }
        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    public static void main(String[] args) {
        EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
        empWageBuilder.addCompanyEmpWage("dMart",20,2,10);
        empWageBuilder.addCompanyEmpWage("Reliance",30,2,20);
        empWageBuilder.computeEmpWage();
    }
}
