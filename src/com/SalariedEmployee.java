package com;

public class SalariedEmployee extends Employee {

    private int annualSalary;

    public int getAnnualSalary(){
        return annualSalary;
    }

    SalariedEmployee(Name name, Address address, Date date, int id, int annualSalary ) {
        super(name, address, date, id);
        this.annualSalary = annualSalary;
    }

}
