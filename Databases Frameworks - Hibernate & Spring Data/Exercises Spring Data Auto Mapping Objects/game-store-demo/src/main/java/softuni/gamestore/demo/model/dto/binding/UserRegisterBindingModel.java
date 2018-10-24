package softuni.gamestore.demo.model.dto.binding;

import softuni.gamestore.demo.validators.EmailValidator;

public class UserRegisterBindingModel {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterBindingModel() {
    }

    public UserRegisterBindingModel(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }
    @EmailValidator
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPasswordMatch() {
        return this.password.trim().equals(this.confirmPassword.trim());
    }
}
