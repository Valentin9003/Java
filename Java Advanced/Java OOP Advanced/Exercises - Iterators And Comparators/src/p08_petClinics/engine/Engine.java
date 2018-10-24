package p08_petClinics.engine;

import p08_petClinics.controller.impl.CommandDispatcher;
import p08_petClinics.controller.interfaces.Dispatcher;
import p08_petClinics.io.impl.ConsoleReader;
import p08_petClinics.io.impl.ConsoleWriter;
import p08_petClinics.io.interfaces.Reader;
import p08_petClinics.io.interfaces.Writer;
import p08_petClinics.until.Config;

public class Engine {

    private Reader reader;
    private Writer writer;
    private Dispatcher commandDispatcher;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.commandDispatcher = new CommandDispatcher();
    }

    public final void run() {
        int numberOfCommands = Integer.parseInt(this.reader.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandTokens = this.reader.readLine().split("\\s+");
            dispatcher(commandTokens);
        }
    }

    private void dispatcher(String[] commandTokens) {
        String command = commandTokens[0];
        switch (command) {
            case Config.CREATE_COMMAND:
                executeCreate(commandTokens);
                break;
            case Config.ADD_COMMAND:
                executeAdd(commandTokens);
                break;
            case Config.RELEASE_COMMAND:
                executeRelease(commandTokens[1]);
                break;
            case Config.HAS_EMPTY_ROOMS_COMMAND:
                executeHasEmptyRooms(commandTokens[1]);
                break;
            case Config.PRINT_COMMAND:
                executePrint(commandTokens);
                break;
        }
    }

    private void executeRelease(String clinicName) {
        boolean isRelease = this.commandDispatcher.release(clinicName);
        this.writer.writeLine(isRelease);
    }

    private void executePrint(String[] commandTokens) {
        String clinicName = commandTokens[1];
        if (commandTokens.length == 2) {
            this.writer.writeLine(
                    this.commandDispatcher.print(clinicName));
        } else if (commandTokens.length == 3) {
            int roomIndex = Integer.parseInt(commandTokens[2]);
            this.writer.writeLine(
                    this.commandDispatcher.print(clinicName, roomIndex));
        }
    }

    private void executeHasEmptyRooms(String clinicName) {
        boolean hasEmptyRooms = this.commandDispatcher.hasEmptyRooms(clinicName);
        this.writer.writeLine(hasEmptyRooms);
    }

    private void executeAdd(String[] commandTokens) {
        String petName = commandTokens[1];
        String clinicName = commandTokens[2];
        boolean isAdded = this.commandDispatcher.add(petName, clinicName);
        this.writer.writeLine(isAdded);
    }

    private void executeCreate(String[] commandTokens) {
        String objectType = commandTokens[1];
        if (Config.TYPE_PET.equalsIgnoreCase(objectType)) {
            createPet(commandTokens);
        } else {
            createClinic(commandTokens);
        }
    }

    private void createClinic(String[] commandTokens) {
        String clinicName = commandTokens[2];
        int rooms = Integer.parseInt(commandTokens[3]);
        try {
            this.commandDispatcher.createClinic(clinicName, rooms);
        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }

    private void createPet(String[] commandTokens) {
        String petName = commandTokens[2];
        int age = Integer.parseInt(commandTokens[3]);
        String kind = commandTokens[4];
        try {
            this.commandDispatcher.createPet(petName, age, kind);
        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }
}
