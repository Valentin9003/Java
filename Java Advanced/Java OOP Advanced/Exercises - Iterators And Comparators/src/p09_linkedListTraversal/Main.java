package p09_linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        int numberOfLines = Integer.parseInt(reader.readLine());
        while (numberOfLines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add":
                    myLinkedList.add(number);
                    break;
                case "Remove":
                    myLinkedList.remove(number);
                    break;
            }
        }

        System.out.println(myLinkedList.getSize());

        for (Integer number : myLinkedList) {
            System.out.print(number + " ");
        }
    }
}
