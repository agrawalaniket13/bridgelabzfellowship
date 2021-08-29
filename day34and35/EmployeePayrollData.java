package com.bridgelabz;

import java.time.LocalDate;
public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    public LocalDate startDate;
    public String gender;
    public String companyName;
    public int companyId;
    public String department[];

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this(id,name,salary);
        this.startDate = startDate;
    }
    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate, String gender, String companyName,int companyId,String department[]) {
        this(id,name,salary,startDate);
        this.gender = gender;
        this.companyName = companyName;
        this.companyId = companyId;
        this.department = department;
    }

    public String[] getDepartment() {
        return department;
    }

    public void setDepartment(String[] department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id =" + id + ",name =" + name + ",salary =" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o==null || getClass() != o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData)o;
        return id == that.id && Double.compare(that.salary,salary)==0 &&
                name.equals(that.name);
    }

    public void printDepartments() {
        String departments[] = this.getDepartment();
        for(String s: departments) {
            System.out.println("id: "+this.getId()+":"+s);
        }
    }
}
