package p02_warningLevels;

public class Message {

    private Importance importance;
    private String text;

    public Message(String importance, String text) {
        this.setImportance(importance);
        this.setText(text);
    }

    private void setImportance(String importance) {
        this.importance = Enum.valueOf(Importance.class, importance.toUpperCase());
    }

    private void setText(String text) {
        this.text = text;
    }

    public Importance getImportance() {
        return this.importance;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.importance.name(), this.text);
    }
}
