package p02_extendedDatabase;

public class People {

    private Long id;
    private String username;

    public People(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
}
