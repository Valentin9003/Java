package p01_weekdays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeeklyCalendar {

    private final static Comparator<WeeklyEntry> WEEKLY_ENTRY_COMPARATOR_BY_DAY_ASC = createComparatorByDayAsc();

    private List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar() {
        this.weeklyEntries = new ArrayList<>();
    }

    private static Comparator<WeeklyEntry> createComparatorByDayAsc() {
        return Comparator.comparing(WeeklyEntry::getWeekday);
    }

    public void addEntry(String weekday, String notes) {
        this.weeklyEntries.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        this.weeklyEntries.sort(WEEKLY_ENTRY_COMPARATOR_BY_DAY_ASC);
        return this.weeklyEntries;
    }
}
