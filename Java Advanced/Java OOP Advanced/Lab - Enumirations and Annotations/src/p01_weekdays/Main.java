package p01_weekdays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Friday", "sleep");
        wc.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
