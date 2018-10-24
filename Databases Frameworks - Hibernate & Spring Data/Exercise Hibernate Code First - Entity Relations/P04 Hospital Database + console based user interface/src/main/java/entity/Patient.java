package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private boolean medicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Lob
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "has_med_insurance")
    public boolean isMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    @OneToMany(targetEntity = Visitation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "visitation_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_patient_visitation"))
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    private void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public void setNewVisitations(Visitation visitations) {
        this.getVisitations().add(visitations);
    }

    @ManyToMany(targetEntity = Medicament.class, cascade = CascadeType.ALL )
    @JoinTable(name = "patient_medicament",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_pm_patients"),
            inverseForeignKey = @ForeignKey(name = "FK_pm_medicaments"))
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    private void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public void setNewMedicaments(Medicament medicament) {
        this.getMedicaments().add(medicament);
    }

    @ManyToMany(targetEntity = Diagnose.class, cascade = CascadeType.ALL)
    @JoinTable(name = "patients_diagnose",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "FK_pd_patients"),
            inverseForeignKey = @ForeignKey(name = "FK_pd_diagnose"))
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    private void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setNewDiagnose(Diagnose newDiagnose){
        this.getDiagnoses().add(newDiagnose);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Patient: %s %s DateOfBirth: %s%n", this.firstName, this.lastName, this.dateOfBirth))
                .append(String.format("Address: %s%nEmail: %s%n", this.address, this.email))
                .append(String.format("Visitations: %n"));
        for (Visitation visitation : visitations) {
            sb.append(String.format("   - Date: %s  Comments: %s%n", visitation.getDate(), visitation.getComments()));
        }
        sb.append(String.format("Diagnoses: %n"));
        for (Diagnose diag : diagnoses) {
            sb.append(String.format("   - %s -> Comments: %s%n", diag.getName(), diag.getComments()));
        }
        sb.append(String.format("Medicaments: %n"));
        for (Medicament medicament : medicaments) {
            sb.append(String.format("   - %s%n", medicament.getName()));
        }

        return sb.toString();
    }
}
