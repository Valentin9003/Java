package com.company.problem06FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> playersList;

    public Team(String name) {
        this.setName(name);
        this.playersList = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addNewPlayer(Player player) {
        addPlayer(player);
    }

    private void addPlayer(Player player) {
        playersList.add(player);
    }

    public void removePlayer(String playerName) {
        removePlayerFromTheTeam(playerName);
    }

    private void removePlayerFromTheTeam(String playerName) {
        List<Player> bufferList = new ArrayList<>();
        for (Player teamPlayer : playersList) {
            if (!teamPlayer.getName().equals(playerName)) {
                bufferList.add(teamPlayer);
            }
        }

        if (playersList.size() == bufferList.size()) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }

        playersList.clear();
        playersList.addAll(bufferList);
    }

    private int calculateTeamRating() {
        double overallPlayersStats = 0.0;

        if (playersList.size() > 0) {
            for (Player player : playersList) {
                overallPlayersStats += player.getOverallSkillLevel();
            }
            overallPlayersStats /= playersList.size();
        }

        return (int)Math.round(overallPlayersStats);
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.calculateTeamRating());
    }
}
