package com.company;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsAggregator2 {
    final public static String LOG_ROW_PATTERN = "(?<ip>\\d+\\.\\d+\\.\\d+\\.\\d+) (?<name>\\w+) (?<duration>\\d+)";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        TreeMap<String, User> users = new TreeMap<String, User>();
        Pattern row = Pattern.compile(LOG_ROW_PATTERN);
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            Matcher matcher = row.matcher(scan.nextLine());
            matcher.matches();
            String ip = matcher.group("ip");
            String name = matcher.group("name");
            int duration = Integer.parseInt(matcher.group("duration"));

            User user;

            if (users.containsKey(name)) {
                user = users.get(name);
            } else {
                user = new User(name);
            }

            user.addDuration(duration);
            user.addIp(ip);

            users.put(name, user);
        }

        for (User user : users.values()) {
            System.out.println(user.toString());
        }
    }

    private static class User {
        private String name;
        private TreeSet<String> ips;
        private int duration;

        public User(String name) {
            this.name = name;
            ips = new TreeSet<String>();
            duration = 0;
        }

        public void addIp(String ip) {
            ips.add(ip);
        }

        public void addDuration(int duration) {
            this.duration += duration;
        }

        public String toString() {
            return String.format("%s: %d %s", name, duration, ips);
        }
    }
}
