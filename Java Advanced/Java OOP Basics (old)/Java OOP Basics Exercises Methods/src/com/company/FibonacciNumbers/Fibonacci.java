package com.company.FibonacciNumbers;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private List<Integer> fibonacci;

    private Integer startPosition;

    private Integer endPosition;

    public Fibonacci(Integer startPosition, Integer endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.fibonacci = new ArrayList<>();
    }

    public void fillFibonacciList () {
        int firstNumber = 1;
        int secondNumber = 1;
        fibonacci.add(0);
        fibonacci.add(1);
        fibonacci.add(1);

        for (int i = 2; i <= endPosition ; i++) {
            int thirdNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            fibonacci.add(thirdNumber);
        }
    }

    public void printPartOfSequence() {
        for (int i = startPosition; i < endPosition; i++) {
            if (i != endPosition - 1) {
                System.out.print(fibonacci.get(i) + ", ");
            } else {
                System.out.print(fibonacci.get(i));
            }
        }
    }
}
