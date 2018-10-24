package com.company.multipleImplementation;

import com.sun.corba.se.spi.ior.Identifiable;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();
        if (Arrays.asList(citizenInterfaces).contains(com.company.multipleImplementation.Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(com.company.multipleImplementation.Identifiable.class)) {
            Method[] methods = com.company.multipleImplementation.Birthable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());

            methods = com.company.multipleImplementation.Identifiable.class.getDeclaredMethods();
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthdate = scanner.nextLine();

            com.company.multipleImplementation.Identifiable identifiable = new Citizen(name,age,id,birthdate);
            Birthable birthable = new Citizen(name,age,id,birthdate);
        }

    }

}
