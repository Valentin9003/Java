package models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet {

    private Long id;
    private Double betMoney;
    private LocalDateTime dateTime;
    private User user;

    public Bet() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bet_money")
    public Double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(Double betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_bet_user"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
