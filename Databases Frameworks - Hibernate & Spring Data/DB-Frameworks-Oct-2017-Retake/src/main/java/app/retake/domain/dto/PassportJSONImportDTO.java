package app.retake.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class PassportJSONImportDTO implements Serializable {

    @Expose
    //exactly 10 characters and ending with 3 digits, primary identification field
    @Pattern(regexp = "^[^\\s]{7}\\d{3}$")
    private String serialNumber;

    @Expose
    @Size(min = 3, max = 30)
    private String ownerName;

    @Expose
    //Either starts with +359 and 9 digits following OR consists of exacly 10 digits, starting with 0
    @Pattern(regexp = "(?:\\+359|0)\\d{9}")
    private String ownerPhoneNumber;

    @Expose
    private Date registrationDate;

    public PassportJSONImportDTO() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
