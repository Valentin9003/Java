package com.company;

import java.util.Scanner;

public class BoatSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char characterOfTheFirstBoat = scanner.nextLine().charAt(0);
        char characterOfTheSecondBoat = scanner.nextLine().charAt(0);
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        int counterPtFirstBoat = 0;
        int counterPtSecondBoat = 0;
        int updateFirstBoat =  characterOfTheFirstBoat;
        int updateSecondBoat =  characterOfTheSecondBoat;
        int updateCounter = 0;

        for (int i = 1; i <= numberOfLines ; i++)
        {
            String inputMove = scanner.nextLine();
            boolean isEvenRow = false;
            boolean isUpdate = false;

            if (i % 2 == 0) {
                isEvenRow = true;
            }

            if (inputMove.equals("UPGRADE")) {
                    updateFirstBoat += 3;
                    updateSecondBoat += 3;
                    isUpdate = true;
                    updateCounter++;
            }

                if (isEvenRow && !isUpdate) {
                    counterPtSecondBoat += inputMove.length();
                } else if (!isEvenRow && !isUpdate){
                    counterPtFirstBoat += inputMove.length();
                }

                if (updateCounter == 0) {
                    if (counterPtFirstBoat >= 50) {
                        System.out.println(characterOfTheFirstBoat);
                        return;
                    } else if (counterPtSecondBoat >= 50) {
                        System.out.println(characterOfTheSecondBoat);
                        return;
                    }
                } else {
                    if (counterPtFirstBoat >= 50) {
                        System.out.println((char) updateFirstBoat);
                        return;
                    } else if (counterPtSecondBoat >= 50) {
                        System.out.println((char) updateSecondBoat);
                        return;
                    }
                }
        }

        if (updateCounter == 0) {
            if (counterPtFirstBoat > counterPtSecondBoat) {
                System.out.println(characterOfTheFirstBoat);
            } else {
                System.out.println(characterOfTheSecondBoat);
            }
        } else {
            if (counterPtFirstBoat > counterPtSecondBoat) {
                System.out.println((char) updateFirstBoat);
            } else {
                System.out.println((char) updateSecondBoat);
            }
        }
    }
}
