package p02_multipleInheritance;

import p02_multipleInheritance.models.Puppy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Puppy puppy = new Puppy();
        puppy.eat();
        puppy.bark();
        puppy.weep();
    }
}
