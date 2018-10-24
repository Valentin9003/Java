package p05_borderControl;

import p05_borderControl.models.contracts.Passport;
import p05_borderControl.models.contracts.City;
import p05_borderControl.models.impl.CitizenImpl;
import p05_borderControl.models.impl.CityImpl;
import p05_borderControl.models.impl.RobotImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final String STOP = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = readInputData(reader);

        String fakeIdDigits = reader.readLine();
        City cityControl = new CityImpl(fakeIdDigits);

        borderControlPassports(lines, cityControl);

        System.out.println(cityControl);
    }

    private static void borderControlPassports(List<String> lines, City cityControl) {
        Passport passport = null;
        for (String inputLine : lines) {
            String[] tokens = inputLine.split("\\s+");

            if (tokens.length == 2) {
                passport = getRobotPassport(tokens);
            } else {
                passport = getCitizenPassport(tokens);
            }

            cityControl.check(passport);
        }
    }

    private static Passport getCitizenPassport(String[] tokens) {
        Passport passport;
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String id = tokens[2];
        passport = new CitizenImpl(name, age, id);
        return passport;
    }

    private static Passport getRobotPassport(String[] tokens) {
        Passport passport;
        String model = tokens[0];
        String id = tokens[1];
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
