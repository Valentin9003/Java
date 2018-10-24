package engine;

import io.impl.ConsoleReaderImpl;
import io.impl.ConsoleWriterImpl;
import io.interfaces.Reader;
import io.interfaces.Writer;
import controller.CarManager;
import controller.Manager;
import util.Config;

public class Engine {

    private Reader reader;
    private Writer writer;
    private Manager carManager;

    public Engine() {
        this.reader = new ConsoleReaderImpl();
        this.writer = new ConsoleWriterImpl();
        this.carManager = new CarManager();
    }

    public void run() {
        //TODO... here is the main logic
        String line;
        while (!Config.STOP_PROGRAM.equalsIgnoreCase(line = this.reader.readLine())) {
            String[] commArgs = line.split("\\s+");

            int id;
            switch (commArgs[0]) {
                case Config.REGISTER_COMMAND:
                    executeRegisterNewCar(commArgs);
                    break;
                case Config.CHECK_COMMAND:
                    executeCheckCarInfo(commArgs);
                    break;
                case Config.OPEN_COMMAND:
                    executeOpenNewRace(commArgs);
                    break;
                case Config.PARTICIPATE_COMMAND:
                    executeAddParticipates(commArgs);
                    break;
                case Config.START_COMMAND:
                    executeStartRace(commArgs);
                    break;
                case Config.PARK_COMMAND:
                    executeParkingCarInTheGarage(commArgs);
                    break;
                case Config.UNPARK_COMMAND:
                    executeUnparkCarFromTheGarage(commArgs);
                    break;
                case Config.TUNE_COMMAND:
                    executeTune(commArgs);
                    break;
            }
        }
    }

    private void executeTune(String[] commArgs) {
        //tune {tuneIndex} {tuneAddOn}
        int tuneIndex = Integer.parseInt(commArgs[1]);
        String tuneAddOn = commArgs[2];
        this.carManager.tune(tuneIndex, tuneAddOn);
    }

    private void executeUnparkCarFromTheGarage(String[] commArgs) {
        int carId = Integer.parseInt(commArgs[1]);
        this.carManager.unpark(carId);
    }

    private void executeParkingCarInTheGarage(String[] commArgs) {
        //park {carId}
        int carId = Integer.parseInt(commArgs[1]);
        try {
            this.carManager.park(carId);
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }

    private void executeAddParticipates(String[] commArgs) {
        //participate {carId} {raceId}
        int carId = Integer.parseInt(commArgs[1]);
        int raceId = Integer.parseInt(commArgs[2]);
        this.carManager.participate(carId, raceId);
    }

    private void executeStartRace(String[] commArgs) {
        //start {raceId}
        int raceId = Integer.parseInt(commArgs[1]);
        try {
            String raceResults = this.carManager.start(raceId);
            this.writer.writeLine(raceResults);
        } catch (IllegalArgumentException iae) {
            this.writer.writeLine(iae.getMessage());
        }
    }

    private void executeOpenNewRace(String[] commArgs) {
        //open {id} {type} {length} {route} {prizePool}
        int id = Integer.parseInt(commArgs[1]);
        String type = commArgs[2];
        int length = Integer.parseInt(commArgs[3]);
        String route = commArgs[4];
        int prizePool = Integer.parseInt(commArgs[5]);

        if (commArgs.length == 6) {
            this.carManager.open(id, type, length, route, prizePool);
        } else {
            int extraParameter = Integer.parseInt(commArgs[6]);
            this.carManager.open(id, type, length, route, prizePool, extraParameter);
        }
    }

    private void executeCheckCarInfo(String[] commArgs) {
        //•	check {id}
        int id = Integer.parseInt(commArgs[1]);
        try {
            String representationOfTheCar = this.carManager.check(id);
            this.writer.writeLine(representationOfTheCar);
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }

    private void executeRegisterNewCar(String[] commArgs) {
        //register {id} {type} {brand} {model} {year} {horsepower} {acceleration} {suspension} {durability}
        int id = Integer.parseInt(commArgs[1]);
        String type = commArgs[2];
        String brand = commArgs[3];
        String model = commArgs[4];
        int year = Integer.parseInt(commArgs[5]);
        int horsepower = Integer.parseInt(commArgs[6]);
        int acceleration = Integer.parseInt(commArgs[7]);
        int suspension = Integer.parseInt(commArgs[8]);
        int durability = Integer.parseInt(commArgs[9]);

        this.carManager.register(
                id,
                type,
                brand,
                model,
                year,
                horsepower,
                acceleration,
                suspension,
                durability);
    }
}
