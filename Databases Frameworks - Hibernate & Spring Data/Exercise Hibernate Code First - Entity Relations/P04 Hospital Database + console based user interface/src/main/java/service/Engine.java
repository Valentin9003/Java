package service;

import entity.Diagnose;
import entity.Medicament;
import entity.Patient;
import entity.Visitation;
import service.commands.CommandExecutor;
import service.menu.Menu;
import service.manager.PatientManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Engine {

    private EntityManagerFactory factory;
    private CommandExecutor cExecutor;
    private PatientManager pManager;
    private Menu menu;

    public Engine() {
        this.factory = Persistence.createEntityManagerFactory("ExerciseHibernate");
        this.cExecutor = new CommandExecutor<>(factory);
        this.pManager = new PatientManager();
        this.menu = new Menu();
    }

    public void run() throws IOException {
        menu.showStartMenu();
        while (!menu.getCommand().equals("4")) {
            executeCommand(menu.getCommand());
            menu.showStartMenu();
        }
        this.cExecutor.closeEntityManager();
        this.factory.close();
    }

    private void executeCommand(String command) throws IOException {
        switch (command) {
            case "1":
                try {
                    Patient patient = pManager.selectPatientById(cExecutor);
                    showPatientMenu(patient);
                } catch (NoResultException e) {
                    System.out.println("Don't have patient in DB with the given id.");
                }
                break;
            case "2":
                Patient patient = pManager.insertNewPatientInfo();
                cExecutor.save(patient);
                System.out.println(String.format("New patient: %s %s was added successfully.",
                        patient.getFirstName(), patient.getLastName()));
                break;
            case "3":
                List<Patient> patientList = cExecutor.findAll(Patient.class);
                pManager.showAllPatientsInDb(patientList);
                break;
        }
    }

    private void showPatientMenu(Patient patient) throws IOException {
        System.out.println(String.format("Id:%d Patient: %s %s",
                patient.getId(), patient.getFirstName(), patient.getLastName()));
        menu.showPatientMenu();
        while (!menu.getCommand().equals("6")) {
            executePatientCommand(patient);
            menu.showPatientMenu();
        }
    }

    private void executePatientCommand(Patient patient) throws IOException {
        switch (menu.getCommand()) {
            case "1":
                System.out.println(patient.toString());
                break;
            case "2":
                Visitation visitation = pManager.insertNewVisitationComment();
                cExecutor.addVisitation(patient, visitation);
                break;
            case "3":
                Diagnose diagnose = pManager.insertNewDiagnoseInfo();
                cExecutor.addDiagnose(patient, diagnose);
                break;
            case "4":
                Medicament medicament = pManager.insertNewMedicamentInfo();
                cExecutor.addNewMedicament(medicament, patient);
                break;
            case "5":
                pManager.deletePatient(patient, cExecutor);
                run();
        }
    }
}
