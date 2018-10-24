package p06_footballTeamGenerator.models;

import p06_footballTeamGenerator.util.ConfigExMessage;

public class Stat {

    private static final String ENDURANCE_STAT_NAME = "Endurance";
    private static final String SPRINT_STAT_NAME = "Sprint";
    private static final String DRIBBLE_STAT_NAME = "Dribble";
    private static final String PASSING_STAT_NAME = "Passing";
    private static final String SHOOTING_STAT_NAME = "Shooting";
    private static final double SKILLS_COUNT = 5.0;

    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Stat(int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setEndurance(int endurance) {
        if (outOfRange(endurance)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.INVALID_STAT_RANGE_EX_MESSAGE, ENDURANCE_STAT_NAME));
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (outOfRange(sprint)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.INVALID_STAT_RANGE_EX_MESSAGE, SPRINT_STAT_NAME));
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (outOfRange(dribble)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.INVALID_STAT_RANGE_EX_MESSAGE, DRIBBLE_STAT_NAME));
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (outOfRange(passing)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.INVALID_STAT_RANGE_EX_MESSAGE, PASSING_STAT_NAME));
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (outOfRange(shooting)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.INVALID_STAT_RANGE_EX_MESSAGE, SHOOTING_STAT_NAME));
        }
        this.shooting = shooting;
    }

    private boolean outOfRange(int number) {
        return number < 0 || number > 100;
    }

    public double getOverallSkillLevel() {
        double totalSkillsLevel =
                this.endurance + this.sprint + this.dribble + this.passing + this.shooting;

        return totalSkillsLevel / SKILLS_COUNT;
    }
}
