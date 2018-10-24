package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BPMCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("####.#");

        int  BPM = Integer.parseInt(scanner.nextLine());
        int  beats = Integer.parseInt(scanner.nextLine());

        System.out.printf("%s bars - ", df.format(beats/4.0));

        double seconds = beats * 60.0 / BPM;
        int minutes = (int) seconds / 60;
        seconds -= minutes * 60;

        System.out.printf("%dm %.0fs", minutes, seconds);
    }
}