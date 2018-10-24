package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.ICustomer;

public class Customer extends Person implements ICustomer {

    private double purchasesAmount;

    public Customer(String id, String firstName, String lastName, double purchasesAmount) {
        super(id, firstName, lastName);
        this.setPurchasesAmount(purchasesAmount);
    }


    public double getPurchasesAmount() {
        return purchasesAmount;
    }

    private void setPurchasesAmount(double netPurchaseAmount) {
        if (netPurchaseAmount < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.purchasesAmount = netPurchaseAmount;
    }

    @Override
    public void addPurchasePrice(double purchasePrice) {
        this.purchasesAmount += purchasePrice;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "purchasesAmount=" + purchasesAmount +
                '}';
    }
}
