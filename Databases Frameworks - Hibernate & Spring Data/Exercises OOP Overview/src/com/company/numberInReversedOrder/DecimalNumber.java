package com.company.numberInReversedOrder;

public class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.setNumber(number);
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public String getNumberInReverseOrder(){
        StringBuilder sb = new StringBuilder(this.number);
        return sb.reverse().toString();
    }
}
