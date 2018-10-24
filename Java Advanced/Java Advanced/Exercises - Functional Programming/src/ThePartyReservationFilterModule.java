import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> invitationList =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .collect(Collectors.toList());

        List<String> filterInvitation = new ArrayList<>();

        String tokens = reader.readLine();
        while (!"Print".equals(tokens)) {
            executeCommand(invitationList, filterInvitation, tokens);

            tokens = reader.readLine();
        }

        filteringAndPrintResult(invitationList, filterInvitation);
    }

    private static void filteringAndPrintResult(List<String> invitationList, List<String> filterInvitation) {
        filterInvitation.forEach(i -> invitationList.remove(i));

        System.out.println(String.join(" ", invitationList));
    }

    private static void executeCommand(List<String> invitationList, List<String> filterInvitation, String tokens) {
        String command = tokens.split("\\s+")[0];
        String filter = tokens.split(";")[1];
        String parameter = tokens.split(";")[2];

        switch (command) {
            case "Add":
                for (String invite : invitationList) {
                    if (getPredicateType(filter, parameter).test(invite)) {
                        filterInvitation.add(invite);
                    }
                }
                break;
            case "Remove":
                for (String invite : invitationList) {
                    if (getPredicateType(filter, parameter).test(invite)) {
                        filterInvitation.remove(invite);
                    }
                }
                break;
        }
    }

    private static Predicate<String> getPredicateType(String filter, String parameter) {
        switch (filter) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Contains":
                return s -> s.contains(parameter);
            default:
                int parameterLength = Integer.parseInt(parameter);
                return s -> s.length() == parameterLength;
        }
    }
}
