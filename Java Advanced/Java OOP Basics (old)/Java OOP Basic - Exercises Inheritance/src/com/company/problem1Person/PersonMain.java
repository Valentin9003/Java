package com.company.problem1Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PersonMain {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //Just try the program for bugs
        try {
            Person person = new Child("Gosho", 20);
            System.out.println(person.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person person = new Child("Ivo", 14);
            System.out.println(person.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person person = new Person("Todor", 0);
            System.out.println(person.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Person person = new Person("Sa", 0);
            System.out.println(person.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
