package com.company.vehicles;

public class CommandCenter {

    public void executeCommand(Vehicles vehicles, String command, double token) {
        switch (command) {
            case "Drive":
                vehicles.driven(token);
                break;
            case "Refuel":
                vehicles.refuel(token);
                break;
        }
    }
}
