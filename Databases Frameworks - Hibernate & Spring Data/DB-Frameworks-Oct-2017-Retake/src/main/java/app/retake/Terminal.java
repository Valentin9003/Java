package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.controllers.ProcedureController;
import app.retake.controllers.VetController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final FileIO fileIO;
    private final ConsoleIO consoleIO;
    private final AnimalAidController animalAidController;
    private final AnimalController animalController;
    private final VetController vetController;
    private final ProcedureController procedureController;

    @Autowired
    public Terminal(FileIO fileIO,
                    ConsoleIO consoleIO,
                    AnimalAidController animalAidController,
                    AnimalController animalController,
                    VetController vetController,
                    ProcedureController procedureController) {
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.animalAidController = animalAidController;
        this.animalController = animalController;
        this.vetController = vetController;
        this.procedureController = procedureController;
    }

    @Override
    public void run(String... strings) throws Exception {

        //Import Animal Aids from Json and printing message for every record.
        consoleIO.write(this.animalAidController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.ANIMAL_AIDS_IMPORT_JSON)));

        //Import Animals from Json and printing message for every record.
        consoleIO.write(this.animalController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.ANIMALS_IMPORT_JSON)));

        //Import Vets from Xml and printing message for every record.
        consoleIO.write(this.vetController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.VETS_IMPORT_XML)));

        //Import Procedures from Xml and printing message for every record.
        consoleIO.write(this.procedureController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.PROCEDURES_IMPORT_XML)));

        //JSON Export
        String fileContentJson = this.animalController.exportAnimalsByOwnerPhoneNumber("0887446123");
        this.fileIO.write(fileContentJson, "exportAnimalsByOwnerPhoneNumber.json");

        //XML Export
        String fileContentXml = this.procedureController.exportProcedures();
        this.fileIO.write(fileContentXml, "exportProcedures.xml");
    }
}
