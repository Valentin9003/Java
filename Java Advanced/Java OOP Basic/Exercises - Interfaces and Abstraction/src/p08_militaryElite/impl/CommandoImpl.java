package p08_militaryElite.impl;

import p08_militaryElite.contracts.Commando;
import p08_militaryElite.contracts.Mission;
import p08_militaryElite.contracts.Repair;

import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    Set<Mission> missionSet;

    public CommandoImpl(int id,
                        String firstName,
                        String lastName,
                        double salary,
                        String corps,
                        Set<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missionSet = missions;
    }

    @Override
    public String toString() {
        StringBuilder commando = new StringBuilder(super.toString());
        commando
                .append(System.lineSeparator())
                .append("Missions:");

        for (Mission mission : this.missionSet) {
            commando
                    .append(System.lineSeparator())
                    .append(mission.toString());
        }

        return commando.toString();
    }
}
