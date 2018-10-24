package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.Config;
import org.softuni.mostwanted.controllers.*;
import org.softuni.mostwanted.io.interfaces.ConsoleIO;
import org.softuni.mostwanted.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    private final FileIO fileIO;
    private final ConsoleIO consoleIO;
    private final CarController carController;
    private final DistrictController districtController;
    private final RaceController raceController;
    private final RaceEntryController raceEntryController;
    private final RacerController racerController;
    private final TownController townController;

    @Autowired
    public Terminal(FileIO fileIO,
                    ConsoleIO consoleIO,
                    CarController carController,
                    DistrictController districtController,
                    RaceController raceController,
                    RaceEntryController raceEntryController,
                    RacerController racerController,
                    TownController townController) {
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.carController = carController;
        this.districtController = districtController;
        this.raceController = raceController;
        this.raceEntryController = raceEntryController;
        this.racerController = racerController;
        this.townController = townController;
    }

    @Override
    public void run(String... args) throws Exception {

        //Import Towns from JSON and print message for every record
        consoleIO.write(this.townController
                .importTownsFromJSON(
                        this.fileIO
                                .read(Config.TOWNS_IMPORT_JSON)
                ));

        //Import Districts from JSON and print message for every record
        consoleIO.write(this.districtController
                .importDistrinctsFromJSON(
                        this.fileIO
                                .read(Config.DISTRICTS_IMPORT_JSON)
                ));

        //Import Racers from JSON and print message for every record
        consoleIO.write(this.racerController
                .importRacersFromJSON(
                        this.fileIO
                                .read(Config.RACERS_IMPORT_JSON)
                ));

        //Import Cars from JSON and print message for every record
        consoleIO.write(this.carController
                .importCarsFromJSON(
                        this.fileIO
                                .read(Config.CARS_IMPORT_JSON)
                ));

        //Import race-entries from XML and print message for every record
        consoleIO.write(this.raceEntryController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.RACE_ENTRIES_IMPORT_XML)));


        //TODO......
        consoleIO.write(this.raceController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.RACES_IMPORT_XML)));

        //TODO export data
    }
}
