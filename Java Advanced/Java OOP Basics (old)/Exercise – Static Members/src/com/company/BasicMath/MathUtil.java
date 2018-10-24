package com.company.BasicMath;

public class MathUtil {
    private String command;
    private double firstNumber;
    private double secondNumber;

    public MathUtil(String command, double firstNumber, double secondNumber) {
        this.setCommand(command);
        this.setFirstNumber(firstNumber);
        this.setSecondNumber(secondNumber);
        MathUtil.calculate(command, firstNumber, secondNumber);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    private static void calculate(String command, double firstNumber, double secondNumber) {
        double result = 0;
        switch (command) {
            case "Sum":
                result = firstNumber + secondNumber;
                System.out.printf("%.2f %n", result);
                break;
            case "Subtract":
                result = firstNumber - secondNumber;
                System.out.printf("%.2f %n", result);
                break;
            case "Multiply":
                result = firstNumber * secondNumber;
                System.out.printf("%.2f %n", result);
                break;
            case "Divide":
                result = firstNumber / secondNumber;
                System.out.printf("%.2f %n", result);
                break;
            case "Percentage":
                result = (firstNumber / 100) * secondNumber;
                System.out.printf("%.2f %n", result);
                break;
        }
    }
}
