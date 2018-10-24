package com.company.NumberInReversedOrder;

public class DecimalNumber {

    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public void printDigitsInReversedOrder() {
        StringBuilder sb = new StringBuilder(number);
        System.out.println(sb.reverse().toString());
    }
}
