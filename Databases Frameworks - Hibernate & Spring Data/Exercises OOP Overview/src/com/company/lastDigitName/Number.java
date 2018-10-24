package com.company.lastDigitName;

public class Number {

    private int number;

    public Number(int number) {
        this.setNumber(number);
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public String getEnglishNameOnLastDigit(){
        return lastDigitName(this.number);
    }

    private String lastDigitName(int number) {
        String digitName = "";
        number = number % 10;
        switch (number){
            case 0: digitName = "zero"; break;
            case 1: digitName = "one"; break;
            case 2: digitName = "two"; break;
            case 3: digitName = "three"; break;
            case 4: digitName = "four"; break;
            case 5: digitName = "five"; break;
            case 6: digitName = "six"; break;
            case 7: digitName = "seven"; break;
            case 8: digitName = "eight"; break;
            case 9: digitName = "nine"; break;
        }
        return digitName;
    }
}
