package service.manager;

import entity.Diagnose;
import entity.Medicament;
import entity.Patient;
import entity.Visitation;
import service.commands.CommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PatientManager {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public PatientManager() {
    }

    public Visitation insertNewVisitationComment() throws IOException {
        System.out.println("Enter Visitation comment:");
        String comment = reader.readLine();
        return new Visitation(comment);
    }

    public Diagnose insertNewDiagnoseInfo() throws IOException {
        System.out.println("Diagnose name: ");
        String dName = reader.readLine();
        System.out.println("Diagnose comment: ");
        String dComment = reader.readLine();
        return new Diagnose(dName, dComment);
    }

    public Medicament insertNewMedicamentInfo() throws IOException {
        System.out.println("Medicament: ");
        String mName = reader.readLine();
        return new Medicament(mName);
    }

    public void deletePatient(Patient patient, CommandExecutor cExecutor) {
        cExecutor.remove(patient);
        System.out.println(String.format("Patient: %s %s was deleted successfully.",
                patient.getFirstName(), patient.getLastName()));
    }

    public Patient selectPatientById(CommandExecutor cExecutor) throws IOException {
        System.out.println("Enter patientID: ");
        Long patientID = Long.parseLong(reader.readLine());
            return (Patient)cExecutor.findById(Patient.class, patientID);
    }

    public void showAllPatientsInDb(List<Patient> patientsList) {
        System.out.println("------------------------------");
        System.out.println("| id | full name | address");
        System.out.println("------------------------------");
        for (Patient pat : patientsList) {
            System.out.println(String.format("| %d | %s %s | %s",
                    pat.getId(), pat.getFirstName(), pat.getLastName(), pat.getAddress()));
        }
        System.out.println("------------------------------");
    }

    public Patient insertNewPatientInfo() throws IOException {
        Patient patientNew = new Patient();
        System.out.println("First name: ");
        patientNew.setFirstName(reader.readLine());
        System.out.println("Last name: ");
        patientNew.setLastName(reader.readLine());
        System.out.println("Address: ");
        patientNew.setAddress(reader.readLine());
        System.out.println("Email: ");
        patientNew.setEmail(reader.readLine());
        System.out.println("Medical Insurance yes/no: ");
        String medicalInsurance = reader.readLine();
        if (medicalInsurance.equalsIgnoreCase("yes")) {
            patientNew.setMedicalInsurance(true);
        } else if (medicalInsurance.equalsIgnoreCase("no")) {
            patientNew.setMedicalInsurance(false);
        }
        return patientNew;
    }
}
