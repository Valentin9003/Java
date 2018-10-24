package p06_footballTeamGenerator.models;

import p06_footballTeamGenerator.util.ConfigExMessage;

import java.util.*;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_NAME_EX_MESSAGE);
        }
        this.name = name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    private int getRating() {
        double rating = 0.0;
        if (this.getPlayers().size() > 0) {
            rating = this.players.stream()
                    .mapToDouble(player -> player.getStats().getOverallSkillLevel())
                    .average().getAsDouble();
        }

        return (int)Math.round(rating);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player player = getThePlayerFromDatabase(playerName);

        if (player == null) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.MISSING_PLAYER_EX_MESSAGE, playerName, this.getName()));
        }

        this.players.remove(player);
    }

    private Player getThePlayerFromDatabase(String playerName) {
        Optional<Player> matchingObject =
                this.players.stream().
                filter(p -> p.getName().equals(playerName))
                        .findFirst();

        return matchingObject.orElse(null);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getRating());
    }
}
