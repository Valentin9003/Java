package p11_catLady;

import p11_catLady.models.Cat;
import p11_catLady.models.breeds.Cymric;
import p11_catLady.models.breeds.Siamese;
import p11_catLady.models.breeds.StreetExtraordinaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String STOP = "End";
    private static final String SIAMESE_BREED = "Siamese";
    private static final String CYMRIC_BREED = "Cymric";
    private static final String STREET_EXTRAORDINAIRE_BREED = "StreetExtraordinaire";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Cat> catsDB = new ArrayList<>();

        String line;
        while (!STOP.equalsIgnoreCase(line = reader.readLine())) {
            String[] catData = line.split("\\s+");

            fillCatsDatabase(catsDB, catData);
        }

        printInfoForTheGivenCat(reader, catsDB);
    }

    private static void printInfoForTheGivenCat(BufferedReader reader, List<Cat> catsDB) throws IOException {
        String catName = reader.readLine();
        catsDB.stream()
                .filter(cat -> cat.getName().equals(catName))
                .limit(1)
                .forEach(System.out::println);
    }

    private static void fillCatsDatabase(List<Cat> catsDB, String[] catData) {
        String catBreed = catData[0];
        String catName = catData[1];
        double specificCharacteristics = Double.parseDouble(catData[2]);

        Cat cat = null;
        switch (catBreed) {
            case SIAMESE_BREED:
                cat = new Siamese(catName, specificCharacteristics);
                break;
            case CYMRIC_BREED:
                cat = new Cymric(catName, specificCharacteristics);
                break;
            case STREET_EXTRAORDINAIRE_BREED:
                cat = new StreetExtraordinaire(catName, specificCharacteristics);
                break;
        }
        catsDB.add(cat);
    }
}
