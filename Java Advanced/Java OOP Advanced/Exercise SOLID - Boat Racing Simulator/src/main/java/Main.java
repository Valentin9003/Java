import Core.BoatRacingSimulatorEngine;
import Core.CommandHandlerImpl;
import contracts.*;
import contracts.Runnable;
import controllers.BoatSimulatorControllerImpl;
import repository.BoatRepository;
import repository.EngineRepository;
import io.ConsoleReader;
import io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {

        Writer writer = new ConsoleWriter();
        Reader reader = new ConsoleReader();

        Repository<Boat> boatRepository = new BoatRepository();
        Repository<Engine> engineRepository = new EngineRepository();
        BoatSimulatorController boatSimulatorController = new BoatSimulatorControllerImpl(boatRepository, engineRepository);

        CommandHandler commandHandler = new CommandHandlerImpl(boatSimulatorController);

        Runnable engine = new BoatRacingSimulatorEngine(commandHandler, writer, reader);
        engine.run();
    }
}
