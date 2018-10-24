package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AdvertisementMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Message newMes = new Message();

        int printTimes = Integer.parseInt(reader.readLine());

//        for (int i = 1; i <= printTimes; i++) {
//            System.out.println(String.format("%s %s %s – %s."
//                    , newMes.Phrase[newMes.RandomPhraseIndex()]
//                    , newMes.Events[newMes.RandomEventIndex()]
//                    , newMes.Authors[newMes.RandomAuthorIndex()]
//                    , newMes.Cities[newMes.RandomCitiesIndex()]));
//        }

    }
}
class Message
{
    String[] Phrase = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category"
            , "Exceptional product.", "I can’t live without this product."};
    String[] Events ={"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!"
            , "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
    String[] Authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    String[] Cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    public int RandomPhraseIndex()
    {
        int pIndex = ThreadLocalRandom.current().nextInt(0, Phrase.length);
        return pIndex;
    }
    public int RandomEventIndex()
    {
        int eIndex = ThreadLocalRandom.current().nextInt(0, Events.length);
        return eIndex;
    }
    public int RandomAuthorIndex()
    {
        int aIndex = ThreadLocalRandom.current().nextInt(0, Authors.length);
        return aIndex;
    }
    public int RandomCitiesIndex()
    {
        int cIndex = ThreadLocalRandom.current().nextInt(0, Cities.length);
        return cIndex;
    }

}

