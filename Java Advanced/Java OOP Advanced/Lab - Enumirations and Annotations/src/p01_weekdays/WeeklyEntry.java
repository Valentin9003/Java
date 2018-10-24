package p01_weekdays;

public class WeeklyEntry {

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.setWeekday(weekday);
        this.setNotes(notes);
    }

    private void setWeekday(String weekday) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    public String getNotes() {
        return this.notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday.toString(), this.notes);
    }
}
