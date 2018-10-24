package com.company;

import java.io.*;
import java.util.Random;

public class AdvertisementMessage {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phrases = { "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product." };
        String[] events = { "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!" };
        String[] author = { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };
        String[] cities = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

        int numberOfMessages = Integer.parseInt(reader.readLine());

        Writer writerOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("outputP07.txt"), "utf-8"));
        {
            Random generator = new Random();
            for (int i = 1; i <= numberOfMessages; i++) {

            int randIndexP = generator.nextInt(phrases.length);
            int randIndexE = generator.nextInt(events.length);
            int randIndexA = generator.nextInt(author.length);
            int randIndexC = generator.nextInt(cities.length);

            writerOutput.write(String.format("%s %s %s - %s%n", phrases[randIndexP], events[randIndexE], author[randIndexA], cities[randIndexC]));
            }
        }
        writerOutput.close();
    }
}
