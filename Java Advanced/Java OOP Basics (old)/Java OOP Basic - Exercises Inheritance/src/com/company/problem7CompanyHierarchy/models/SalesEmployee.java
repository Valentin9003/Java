package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.ISale;

import java.util.HashSet;
import java.util.Set;

public class SalesEmployee extends RegularEmployee implements ISale {

    private Set<Sale> sales;


    public SalesEmployee(String id, String firstName, String lastName, Department department, double salary) {
        super(id, firstName, lastName, department, salary);
        this.sales = new HashSet<>();
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void addSale(HashSet<Sale> sales) {
        this.sales.addAll(sales);
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "sales=" + sales +
                '}';
    }
}
