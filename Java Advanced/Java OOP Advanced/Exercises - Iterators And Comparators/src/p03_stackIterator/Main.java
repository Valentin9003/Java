package p03_stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyStack<Integer> stack = new MyStack<>();

        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "Push":
                    tokens = tokens[1].split(",\\s+");
                    for (String item : tokens) {
                        stack.push(Integer.valueOf(item.trim()));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        for (Integer item : stack) {
            System.out.println(item);
        }
        for (Integer item : stack) {
            System.out.println(item);
        }
    }
}
