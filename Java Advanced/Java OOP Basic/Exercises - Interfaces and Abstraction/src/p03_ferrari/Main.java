package p03_ferrari;

import p03_ferrari.models.contracts.Car;
import p03_ferrari.models.impl.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String driverName = reader.readLine();
        Car car = new Ferrari(driverName);

        System.out.println(car);


        /**All reflection down is for Judge, to test the problem*/
        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();

        try {
            if (!isCreated) {
                throw new IllegalClassFormatException("No interface created!");
            }
        } catch (IllegalClassFormatException icfe) {
            System.out.println(icfe.getMessage());
        }

    }
}
