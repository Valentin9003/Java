package com.company;
// 90-100 in Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class CharityMarathon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maratonLengthDays = Integer.parseInt(reader.readLine());
        long runersParticipate = Long.parseLong(reader.readLine());
        int averageLapsPerRunner = Integer.parseInt(reader.readLine());
        long trackLength = Long.parseLong(reader.readLine());
        int trackCapacity = Integer.parseInt(reader.readLine());
        double moneyPerKilometer = Double.parseDouble(reader.readLine());

        int maxRuners = trackCapacity * maratonLengthDays;
        if (runersParticipate > maxRuners) {
            runersParticipate = maxRuners;
        }

        BigDecimal totalMeters = BigDecimal.valueOf(runersParticipate).multiply(BigDecimal.valueOf(averageLapsPerRunner)).multiply(BigDecimal.valueOf(trackLength));
        BigDecimal totalKM = totalMeters.divide(BigDecimal.valueOf(1000));
        BigDecimal moneyRaised = totalKM.multiply(BigDecimal.valueOf(moneyPerKilometer));

        System.out.println(String.format("Money raised: %.2f", moneyRaised));

    }
}
