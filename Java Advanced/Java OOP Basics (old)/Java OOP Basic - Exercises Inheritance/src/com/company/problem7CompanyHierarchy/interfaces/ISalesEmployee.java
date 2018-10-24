package com.company.problem7CompanyHierarchy.interfaces;

import com.company.problem7CompanyHierarchy.models.Sale;

import java.util.HashSet;
import java.util.Set;

public interface ISalesEmployee {

    Set<Sale> sales = new HashSet<>();

    void addSale(HashSet<Sale> sales);

    String toString();
}
