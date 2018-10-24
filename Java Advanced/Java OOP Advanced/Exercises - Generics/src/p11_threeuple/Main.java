package p11_threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        String address = tokens[2];
        String town = tokens[3];

        Threeuple<Truple<String, String>, String, String> firstThreeuple =
                getThreeuple(new Truple<>(firstName, lastName), address, town);

        tokens = reader.readLine().split("\\s+");
        firstName = tokens[0];
        int beerLiters = Integer.parseInt(tokens[1]);
        boolean isDrunk = "drunk".equals(tokens[2]) ? true : false;

        Threeuple<String, Integer, Boolean> secondThreeuple =
                getThreeuple(firstName, beerLiters, isDrunk);

        tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        double balance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];

        Threeuple<String, Double, String> thirdThreeuple =
                getThreeuple(name, balance, bankName);

        System.out.println(String.format("%s %s -> %s -> %s",
                firstThreeuple.getFirstItem().getFirstItem(),
                firstThreeuple.getFirstItem().getSecondItem(),
                firstThreeuple.getSecondItem(),
                firstThreeuple.getThirdItem()));

        System.out.println(String.format("%s -> %d -> %s",
                secondThreeuple.getFirstItem(),
                secondThreeuple.getSecondItem(),
                secondThreeuple.getThirdItem()));

        System.out.println(String.format("%s -> %s -> %s",
                thirdThreeuple.getFirstItem(),
                thirdThreeuple.getSecondItem(),
                thirdThreeuple.getThirdItem()));
    }

    private static <T, E, R> Threeuple<T, E, R> getThreeuple(T firstItem, E secondItem, R thirdItem) {
        return new Threeuple<>(firstItem, secondItem, thirdItem);
    }
}
