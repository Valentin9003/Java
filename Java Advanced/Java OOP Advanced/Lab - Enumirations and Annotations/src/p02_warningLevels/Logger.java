package p02_warningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private List<Message> messages;
    private Importance restriction;

    public Logger(String restriction) {
        this.restriction = Enum.valueOf(Importance.class, restriction.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        if (message.getImportance().compareTo(this.restriction) >= 0) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
