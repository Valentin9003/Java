package p08_militaryElite.impl;

import p08_militaryElite.contracts.Mission;

public class MissionImpl implements Mission {

    private static final String MISSION_IN_PROGRESS = "inProgress";
    private static final String MISSION_FINISHED = "Finished";

    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (!MISSION_IN_PROGRESS.equals(state) && !MISSION_FINISHED.equals(state)) {
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void CompleteMission() {
        this.state = MISSION_FINISHED;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s",
                this.getCodeName(),
                this.getState());
    }
}
