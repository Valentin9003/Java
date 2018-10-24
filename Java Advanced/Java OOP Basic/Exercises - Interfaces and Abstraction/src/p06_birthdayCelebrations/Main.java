package p06_birthdayCelebrations;

import p06_birthdayCelebrations.models.contracts.City;
import p06_birthdayCelebrations.models.contracts.Mammals;
import p06_birthdayCelebrations.models.contracts.Passport;
import p06_birthdayCelebrations.models.impl.CitizenImpl;
import p06_birthdayCelebrations.models.impl.CityImpl;
import p06_birthdayCelebrations.models.impl.PetImpl;
import p06_birthdayCelebrations.models.impl.RobotImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final String STOP = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Mammals> mammalsDB = new LinkedList<>();
        List<String> lines = readInputData(reader);
        String year = reader.readLine();
        borderControlPassports(lines, mammalsDB);

        mammalsDB
                .stream()
                .filter(mammal -> mammal.getBirthdate().endsWith(year))
                .forEach(mammal -> {
                    System.out.println(mammal.getBirthdate());
                });
    }

    private static void borderControlPassports(List<String> lines, List<Mammals> mammalsDB) {
        Mammals mammal = null;
        for (String inputLine : lines) {
            String[] tokens = inputLine.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    mammal = getCitizenPassport(tokens);
                    mammalsDB.add(mammal);
                    break;
                case "Pet":
                    mammal = getPetData(tokens);
                    mammalsDB.add(mammal);
                    break;
                case "Robot":
                    /**deprecate*/
                    Passport passport = getRobotPassport(tokens);
                    break;
            }

        }
    }

    private static Mammals getPetData(String[] tokens) {
        String name = tokens[1];
        String birth = tokens[2];
        return new PetImpl(name, birth);
    }

    private static Mammals getCitizenPassport(String[] tokens) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String id = tokens[3];
        String birthdate = tokens[4];
        return  new CitizenImpl(name, age, id, birthdate);
    }

    private static Passport getRobotPassport(String[] tokens) {
        Passport passport;
        String model = tokens[1];
        String id = tokens[2];
        passport = new RobotImpl(model, id);
        return passport;
    }

    private static List<String> readInputData(BufferedReader reader) throws IOException {
        List<String> lines = new LinkedList<>();
        String line;
        while (!STOP.equals(line = reader.readLine())) {
            lines.add(line);
        }
        return lines;
    }
}
