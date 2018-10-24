import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emailBook = new LinkedHashMap<>();

        String command = "";
        while (!"stop".equals(command = reader.readLine())) {
            String email = reader.readLine();
            if (isValid(email)) {
                fillEmailsDatabase(emailBook, command, email);
            }
        }

        emailBook.keySet().forEach(e -> {
            System.out.println(String.format("%s -> %s", e, emailBook.get(e)));
        });
    }

    private static void fillEmailsDatabase(Map<String, String> emailBook, String name, String email) {
        if (emailBook.containsKey(name)) {
            emailBook.replace(name, email);
        }
        emailBook.putIfAbsent(name, email);
    }

    private static boolean isValid(String email) {
        if (email.endsWith("us")
                || email.endsWith("uk")
                || email.endsWith("com")) {
            return false;
        }
        return true;
    }
}
