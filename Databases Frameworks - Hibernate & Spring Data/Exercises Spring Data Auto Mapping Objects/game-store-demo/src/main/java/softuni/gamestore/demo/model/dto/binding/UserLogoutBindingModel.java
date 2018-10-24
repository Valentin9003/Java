package softuni.gamestore.demo.model.dto.binding;

public class UserLogoutBindingModel {

    private String email;

    public UserLogoutBindingModel() {
    }

    public UserLogoutBindingModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
