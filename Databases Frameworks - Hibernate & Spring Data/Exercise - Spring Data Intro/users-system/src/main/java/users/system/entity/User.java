package users.system.entity;

import users.system.validators.Age;
import users.system.validators.Email;
import users.system.validators.Password;
import users.system.validators.Picture;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private byte[] picture;
    private Set<Album> albums;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private Integer age;
    private boolean isDeleted;
    private Town bornTown;
    private Town currentlyLivingTown;
    private String firstName;
    private String lastName;
    private Set<User> friends;
    private String fullName;

    public User() {
        this.friends = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    @Size(min = 4, max = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    @Password(containsDigit = true,
            containsLowercase = true,
            containsUppercase = true,
            containsSpecialSymbols = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    @Picture
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "registered_on")
    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    @Age(message = "Invalid age! Age should be between 1 and 120.")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne(targetEntity = Town.class)
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne(targetEntity = Town.class)
    @JoinColumn(name = "living_town_id", referencedColumnName = "id")
    public Town getCurrentlyLivingTown() {
        return currentlyLivingTown;
    }

    public void setCurrentlyLivingTown(Town currentlyLivingTown) {
        this.currentlyLivingTown = currentlyLivingTown;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @Transient
    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @OneToMany(mappedBy = "user", targetEntity = Album.class)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
