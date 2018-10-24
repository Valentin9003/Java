package p08_customListSorter;

import p08_customListSorter.model.impl.MyListImpl;
import p08_customListSorter.model.impl.SortMyList;
import p08_customListSorter.model.interfaces.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String END_PROGRAM = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyList<String> myList = new MyListImpl<>();
        String line;
        while (!END_PROGRAM.equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            commandDispatcher(tokens, myList);
        }
    }

    private static void commandDispatcher(String[] tokens, MyList<String> myList) {
        String command = tokens[0];
        switch (command) {
            case "Add":
                myList.add(tokens[1]);
                break;
            case "Remove":
                myList.remove(Integer.parseInt(tokens[1]));
                break;
            case "Contains":
                System.out.println(myList.contains(tokens[1]));
                break;
            case "Swap":
                myList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "Greater":
                System.out.println(myList.countGreaterThan(tokens[1]));
                break;
            case "Max":
                System.out.println(myList.getMax());
                break;
            case "Min":
                System.out.println(myList.getMin());
                break;
            case "Print":
                myList.getCollection().forEach(System.out::println);
                break;
            case "Sort":
                SortMyList.sort(myList);
                break;
        }
    }
}
