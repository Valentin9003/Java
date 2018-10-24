package p01_eventImplementation;

import p01_eventImplementation.implementations.Dispatcher;
import p01_eventImplementation.implementations.Handler;
import p01_eventImplementation.implementations.EventNameChange;
import p01_eventImplementation.interfaces.NameChangeListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();

        dispatcher.addNameChangeListener(handler);

        String name;
        while (!"End".equalsIgnoreCase(name = reader.readLine())) {
            EventNameChange nameChange = new EventNameChange(name);
            dispatcher.setName(nameChange);
        }
    }
}
