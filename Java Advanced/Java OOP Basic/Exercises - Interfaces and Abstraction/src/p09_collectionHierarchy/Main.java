package p09_collectionHierarchy;

import p09_collectionHierarchy.contracts.AddCollection;
import p09_collectionHierarchy.contracts.AddRemoveCollection;
import p09_collectionHierarchy.contracts.MyList;
import p09_collectionHierarchy.impl.AddCollectionImpl;
import p09_collectionHierarchy.impl.AddRemoveCollectionImpl;
import p09_collectionHierarchy.impl.MyListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addCollection = new AddCollectionImpl();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();


        String[] tokens = reader.readLine().split("\\s+");
        int amountOfRemoveOperations = Integer.parseInt(reader.readLine());

        /**Use a matrix to save all 'add' operations results - for every one collection have a row in the matrix*/
        int[][] matrix = executeAddCommandsForAllCollections(addCollection, addRemoveCollection, myList, tokens);

        /**Print result from add operations from all collections (i am use matrix for it)*/
        printResultFromAddOperationsForAllColections(matrix);

        resultOfRemoveOperations(addRemoveCollection, myList, amountOfRemoveOperations);

    }

    private static void printResultFromAddOperationsForAllColections(int[][] matrix) {
        /**Printing the matrix - and we have first 3 rows from our expecting result separated by whitespace*/
        for (int[] ints : matrix) {
            for (int index : ints) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }

    private static int[][] executeAddCommandsForAllCollections(AddCollection addCollection, AddRemoveCollection addRemoveCollection, MyList myList, String[] tokens) {
        /**Add operation give in result the index on the added element.
         *On first row need print result from all 'add' operations on first collection,
         *on second row -//- on second collection ant on third row from third collection.
         *So for easy printing after that make it with a matrix.
         *The matrix have 3 rows (count on our collections) and col = tokens.length.
         *  - 1st row fill results from add operation on addCollection
         *  - 2nd row fill results from add operation on addRemoveCollection
         *  - 3th row fill results from add operation on myList*/
        int[][] matrix = new int[3][tokens.length];
        int col = 0;
        for (String token : tokens) {
            int row = 0;
            matrix[row][col] = addCollection.add(token);
            row++;
            matrix[row][col] = addRemoveCollection.add(token);
            row++;
            matrix[row][col] = myList.add(token);
            col++;
        }
        return matrix;
    }

    private static void resultOfRemoveOperations(AddRemoveCollection addRemoveCollection, MyList myList, int amountOfRemoveOperations) {
        /**Our collections remove() command have return type String.
         *From console we are read a number - amount of removing commands
         *We need to call remove() so much times - equal to given amount. With 2 loops for both collections
         *(addRemoveCollection, myList) calling remove() and printing result*/

        /**On first row printing all resultStrings from a addRemoveCollection.remove() separated by whitespace,*/
        for (int i = 0; i < amountOfRemoveOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }

        /**On second row printing all resultStrings from a myList.remove() separated by whitespace*/
        System.out.println();
        for (int i = 0; i < amountOfRemoveOperations; i++) {
            System.out.print(myList.remove() + " ");
        }
    }
}
