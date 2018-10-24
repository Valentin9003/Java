package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputDates = reader.readLine();

            String[] inDt = inputDates.split("[-]");
            String name = inDt[0];


        for (int i = 0; i < inDt.length; i++) {
            System.out.println(inDt[i]);
        }
    }
}


//nakov 22/08/2016,20/08/2016
//simeon10 22/08/2016
//end of dates
//nakov-Excellent algorithmetic thinking.
//Gesh4o-Total noob.
//end of comments