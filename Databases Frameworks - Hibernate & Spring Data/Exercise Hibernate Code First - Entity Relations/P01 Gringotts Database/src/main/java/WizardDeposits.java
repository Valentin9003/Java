import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits {

    private Integer id;
    private String first_name;
    private String last_name;
    private String notes;
    private Integer age;
    private String magic_wand_creator;
    private Short magic_wand_size;
    private String deposit_group;
    private LocalDateTime deposit_start_date;
    private Double deposit_amount;
    private Double deposit_interest;
    private Double deposit_charge;
    private LocalDateTime deposit_expiration_date;
    private Boolean is_deposit_expired;

    public WizardDeposits() {
    }

    public WizardDeposits(String first_name, String last_name, String notes, Integer age, String magic_wand_creator, Short magic_wand_size, String deposit_group, LocalDateTime deposit_start_date, Double deposit_amount, Double deposit_interest, Double deposit_charge, LocalDateTime deposit_expiration_date, Boolean is_deposit_expired) {
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setNotes(notes);
        this.setAge(age);
        this.setMagic_wand_creator(magic_wand_creator);
        this.setMagic_wand_size(magic_wand_size);
        this.setDeposit_group(deposit_group);
        this.setDeposit_start_date(deposit_start_date);
        this.setDeposit_amount(deposit_amount);
        this.setDeposit_interest(deposit_interest);
        this.setDeposit_charge(deposit_charge);
        this.setDeposit_expiration_date(deposit_expiration_date);
        this.setIs_deposit_expired(is_deposit_expired);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 50)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "last_name", length = 60, nullable = false)
    @NotNull
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "notes", length = 1000)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "age", nullable = false)
    @Check(constraints = "age >= 0")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "magic_wand_creator", length = 100)
    public String getMagic_wand_creator() {
        return magic_wand_creator;
    }

    public void setMagic_wand_creator(String magic_wand_creator) {
        this.magic_wand_creator = magic_wand_creator;
    }

    @Basic
    public Short getMagic_wand_size() {
        return magic_wand_size;
    }

    public void setMagic_wand_size(Short magic_wand_size) {
        this.magic_wand_size = magic_wand_size;
    }

    @Column(name = "deposit_group", length = 20)
    public String getDeposit_group() {
        return deposit_group;
    }

    public void setDeposit_group(String deposit_group) {
        this.deposit_group = deposit_group;
    }

    @Basic
    public LocalDateTime getDeposit_start_date() {
        return deposit_start_date;
    }

    public void setDeposit_start_date(LocalDateTime deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    @Basic
    public Double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(Double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    @Basic
    public Double getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(Double deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    @Basic
    public Double getDeposit_charge() {
        return deposit_charge;
    }

    public void setDeposit_charge(Double deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    @Basic
    public LocalDateTime getDeposit_expiration_date() {
        return deposit_expiration_date;
    }

    public void setDeposit_expiration_date(LocalDateTime deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    @Basic
    public Boolean getIs_deposit_expired() {
        return is_deposit_expired;
    }

    public void setIs_deposit_expired(Boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }
}
