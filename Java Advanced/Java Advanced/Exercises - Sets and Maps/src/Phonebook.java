import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new HashMap<>();
        fillPhoneBook(reader, phonebook);
        searchInPhoneBook(reader, phonebook);
    }

    private static void searchInPhoneBook(BufferedReader reader, Map<String, String> phonebook) throws IOException {
        String name = reader.readLine();
        while (!"stop".equals(name)) {
            checkForConntactInDatabaseAndPrintResult(name, phonebook);
            name = reader.readLine();
        }
    }

    private static void checkForConntactInDatabaseAndPrintResult(String name, Map<String, String> phonebook) {
        if (phonebook.containsKey(name)) {
            System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
        } else {
            System.out.println(String.format("Contact %s does not exist.", name));
        }
    }

    private static void fillPhoneBook(BufferedReader reader, Map<String, String> phonebook) throws IOException {
        String command = reader.readLine();
        while (!"search".equals(command)) {
            String[] tokens = command.split("-");
            addContactInPhonebook(tokens, phonebook);
            command = reader.readLine();
        }
    }

    private static void addContactInPhonebook(String[] tokens, Map<String, String> phonebook) {
        String name = tokens[0];
        String phoneNumber = tokens[1];
        phonebook.putIfAbsent(name, phoneNumber);
        if (phonebook.containsKey(name)) {
            phonebook.replace(name, phoneNumber);
        }
    }
}
