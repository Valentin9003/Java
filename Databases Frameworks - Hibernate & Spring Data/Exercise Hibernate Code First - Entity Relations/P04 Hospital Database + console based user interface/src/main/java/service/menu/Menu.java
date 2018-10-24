package service.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String command;

    public Menu() {
    }

    public void showStartMenu() throws IOException {
        System.out.println(String.format("  M E N U%n"));
        System.out.println("1. Select Patient");
        System.out.println("2. Add Patient");
        System.out.println("3. Show all patients");
        System.out.println(String.format("4. Exit%n"));

        System.out.println("Command: ");
        this.setCommand(reader.readLine());
    }

    public void showPatientMenu() throws IOException {
        System.out.println(String.format("  M E N U%n"));
        System.out.println("1. Show Info");
        System.out.println("2. Add Visitation");
        System.out.println("3. Add Diagnose");
        System.out.println("4. Add Medicament");
        System.out.println("5. Delete Patient");
        System.out.println(String.format("6. Back%n"));

        System.out.println("Command: ");
        this.setCommand(reader.readLine());
    }

    public String getCommand() {
        return command;
    }

    private void setCommand(String command) {
        this.command = command;
    }
}
