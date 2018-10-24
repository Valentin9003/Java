package com.company;

import java.util.Scanner;

public class CaloriesCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalCalories = 0;

        for (int i = 1; i <= n ; i++) {
            String ingredients = scanner.nextLine().toLowerCase();

            switch (ingredients){
                case "cheese": totalCalories+= 500; break;
                case "tomato sauce": totalCalories+= 150; break;
                case "salami": totalCalories+= 600; break;
                case "pepper": totalCalories+= 50; break;
            }
        }
        System.out.println("Total calories: " + totalCalories);
    }
}
