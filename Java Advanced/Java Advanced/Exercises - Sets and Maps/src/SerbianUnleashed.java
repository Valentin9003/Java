import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SerbianUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("End"))
        {
            String[] inputArr = input.split("@");

            String name = inputArr[0];
            if (name.charAt(name.length() - 1) != ' ') {
                input = reader.readLine();
                continue;
            }

            String[] venuePrice = inputArr[1].split(" ");
            if (venuePrice.length < 3) {
                input = reader.readLine();
                continue;
            }

            String venue = "";
            for (int i = 0; i < venuePrice.length - 2; i++) {
                venue += venuePrice[i] + " ";
            }
            venue = venue.trim();

            int ticketCount = 0;
            int ticketPrice = 0;
            try {
                ticketCount = Integer.parseInt(venuePrice[venuePrice.length - 1]);
                ticketPrice = Integer.parseInt(venuePrice[venuePrice.length - 2]);
            } catch (Exception e) {
                input = reader.readLine();
                continue;
            }

            //Method for add all data in LinkedHashMap<String, LinkedHashMap<String, Integer>>
            addVenuesSingerMoney(venues, venue, name, ticketCount, ticketPrice);

            //Reading again till input is equal on "End"
            input = reader.readLine();
        }

        //Method for printing result
        printResult(venues);

    }

    private static void addVenuesSingerMoney(LinkedHashMap<String, LinkedHashMap<String, Integer>> venues, String venue, String name, int ticketCount, int ticketPrice) {
        if (!venues.containsKey(venue)) {
            venues.put(venue, new LinkedHashMap<>());
        }
        if (!venues.get(venue).containsKey(name)) {
            venues.get(venue).put(name, 0);
        }

        int ticketsSum = ticketCount * ticketPrice;
        int oldSumValue = venues.get(venue).get(name);
        int newSum = oldSumValue + ticketsSum;
        venues.get(venue).put(name, newSum);
    }

    private static void printResult(LinkedHashMap<String, LinkedHashMap<String, Integer>> venues) {
        //Printing the place
        for (Map.Entry<String, LinkedHashMap<String, Integer>> v : venues.entrySet()) {
            System.out.println(v.getKey());

            //Print Name and Sum sorted by sum Descending.
            //If two singers have the same amount of money, keep them
            //>>>in the order in which they were entered. they r in LinkedHashMap<>
            v.getValue().entrySet().stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach(entry -> {
                        System.out.println(String.format("#  %s -> %d", entry.getKey().trim(), entry.getValue()));
                    });
        }
    }
}
