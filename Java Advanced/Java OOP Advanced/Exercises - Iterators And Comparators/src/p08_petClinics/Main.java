package p08_petClinics;

import p08_petClinics.engine.Engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Engine engine = new Engine();
        engine.run();
    }
}
