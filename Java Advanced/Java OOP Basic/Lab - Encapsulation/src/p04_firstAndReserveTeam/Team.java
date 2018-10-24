package p04_firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public List<Person> getFirstTeam() {
        return Collections.synchronizedList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    public void  addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First team have ")
                .append(this.getFirstTeam().size())
                .append(" players")
                .append(System.lineSeparator())
                .append("Reserve team have ")
                .append(this.getReserveTeam().size())
                .append(" players");

        return sb.toString();
    }
}
