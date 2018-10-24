package com.company;

import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length ; i++) {
            primes[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (primes[i])
            {
                for (int j = i * i ; j < primes.length; j += i)
                {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i < primes.length ; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
