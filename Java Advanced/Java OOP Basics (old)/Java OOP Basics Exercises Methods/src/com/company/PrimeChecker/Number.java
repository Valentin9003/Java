package com.company.PrimeChecker;

public class Number {
    static final boolean DEFFAULT_PRIME = true;

    private Integer number;

    private boolean prime;

    public Number(Integer number, boolean prime) {
        this.number = number;
        this.prime = prime;
    }

    public Number(Integer number) {
        this(number, DEFFAULT_PRIME);
    }

    public Integer getNumber() {
        return number;
    }

    public boolean getPrime() {
        return prime;
    }

    public void printNextPrimeNumber() {
        //Checking the giving number isPrime or isn't
        if (number % 2 == 0 && number != 2 && number != 0) {
            prime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        //Find next prime number after the given number
        boolean isPrime = false;
        int n = number + 1;

        while (!isPrime) {
            isPrime = true;
            for (int x = 2; x <= Math.sqrt(n); x++) {
                if (n % x == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                //Printing the next prime number + the Boolean value of the current instance
                System.out.println(n + ", " + prime);
                return;
            }
            else {
                n++;
            }
        }
   }
}
