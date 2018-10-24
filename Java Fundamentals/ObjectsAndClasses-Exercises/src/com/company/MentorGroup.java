package com.company;

//10/100 .........
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

public class MentorGroup {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, List<String>> nameComment = new TreeMap<>();
        HashMap<String, List<String>> nameDate = new HashMap<>();

        String inputDates = reader.readLine();
        while (!inputDates.equals("end of dates"))
        {
            String[] inDt = inputDates.split("[\\s,]");
            String name = inDt[0];
            String[] dates = new String[inDt.length - 1];
            for (int i = 1; i < inDt.length; i++) {
                dates[i - 1] = inDt[i];
            }
            AddNameDates(nameDate, name, dates);

            inputDates = reader.readLine();
        }

        String inputComments = reader.readLine();
        while (!inputComments.equals("end of comments"))
        {
            AddNamesComment(nameComment, inputComments);

            inputComments = reader.readLine();
        }

        Print(nameComment, nameDate);

    }

    private static void Print(TreeMap<String, List<String>> nameComment, HashMap<String, List<String>> nameDate) throws ParseException {

        for (String name : nameDate.keySet()) {
            System.out.println(name);
            System.out.println(String.format("Comments:"));
                if (nameComment.containsKey(name) && nameComment.get(name).size() > 0) {
                    for (String comm : nameComment.get(name)) {
                        System.out.println(String.format("- %s ", comm));
                    }
                }
            System.out.println(String.format("Dates attended:"));
            for (String nameD : nameDate.keySet()) {
                if (nameD.equals(name)) {
                    nameDate.get(nameD).stream().sorted().forEach(x -> {
                        System.out.println("-- " + x);
                    });
                }
            }
        }
    }

    private static void AddNamesComment(TreeMap<String, List<String>> nameComment, String inputComments)
    {
        StudentsClass student = new StudentsClass();

        String[] inDt = inputComments.split("[-]");
        student.Name = inDt[0];
        student.Comments.add(inDt[1].trim());

        if (!nameComment.containsKey(student.Name)) {
            nameComment.put(student.Name, student.Comments);
        } else {
            nameComment.get(student.Name).add(inDt[1]);
        }
    }

    private static void AddNameDates(HashMap<String, List<String>> nameDate, String name, String[] dates) throws ParseException {

        StudentsClass student = new StudentsClass();
        student.Name = name;
        List<String> myList = new ArrayList<>();

        if (!nameDate.containsKey(student.Name)) {
            for (int i = 0; i < dates.length; i++) {
                myList.add(dates[i]);
            }
            nameDate.put(name, myList);
        } else {
            for (int i = 0; i < dates.length; i++) {
                myList.add(dates[i]);
            }
            nameDate.replace(name, myList);
        }
    }
}
class StudentsClass {
    String Name;
    List<String> Comments = new ArrayList<>();
    List<String> AttendDate = new ArrayList<>();
}
