package p09_google;

import p09_google.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final String STOP = "End";
    private static final String TYPE_COMPANY = "company";
    private static final String TYPE_POKEMON = "pokemon";
    private static final String TYPE_PARENTS = "parents";
    private static final String TYPE_CHILDREN = "children";
    private static final String TYPE_CAR = "car";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personsDB = new LinkedHashMap<>();

        String line;
        while (!STOP.equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            personsDB.putIfAbsent(personName, new Person(personName));

            String informationType = tokens[1];
            switch (informationType) {
                case TYPE_COMPANY:
                    setCompany(personsDB, tokens, personName);
                    break;
                case TYPE_POKEMON:
                    addPokemon(personsDB, tokens, personName);
                    break;
                case TYPE_PARENTS:
                    addParent(personsDB, tokens, personName);
                    break;
                case TYPE_CHILDREN:
                    addChildren(personsDB, tokens, personName);
                    break;
                case TYPE_CAR:
                    setCar(personsDB, tokens, personName);
                    break;
            }
        }

        String searchingName = reader.readLine();
        System.out.println(personsDB.get(searchingName));
    }

    private static void setCar(Map<String, Person> personsDB, String[] tokens, String personName) {
        String carModel = tokens[2];
        int carSpeed = Integer.parseInt(tokens[3]);
        Car car = new Car(carModel, carSpeed);
        personsDB.get(personName).setCar(car);
    }

    private static void addChildren(Map<String, Person> personsDB, String[] tokens, String personName) {
        String childrenName = tokens[2];
        String childrenBirth = tokens[3];
        Children child = new Children(childrenName, childrenBirth);
        personsDB.get(personName).addChildren(child);
    }

    private static void addParent(Map<String, Person> personsDB, String[] tokens, String personName) {
        String parentName = tokens[2];
        String parentBirth = tokens[3];
        Parent parent = new Parent(parentName, parentBirth);
        personsDB.get(personName).addParent(parent);
    }

    private static void addPokemon(Map<String, Person> personsDB, String[] tokens, String personName) {
        String pokemonName = tokens[2];
        String pokemonType = tokens[3];
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        personsDB.get(personName).addPokemon(pokemon);
    }

    private static void setCompany(Map<String, Person> personsDB, String[] tokens, String personName) {
        String companyName = tokens[2];
        String department = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Company company = new Company(companyName, department, salary);
        personsDB.get(personName).setCompany(company);
    }
}
