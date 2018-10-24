package p02_warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String restriction = reader.readLine();
        Logger logger = new Logger(restriction);

        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] messageTokens = line.split(": ");
            logger.addMessage(new Message(messageTokens[0], messageTokens[1]));
        }

        Iterable<Message> iterable = logger.getMessages();
        for (Message message : iterable) {
            System.out.println(message);
        }
    }
}
