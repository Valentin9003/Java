package p06_footballTeamGenerator.util;

public final class Config {

    public static final String STOP_PROGRAM_COMMAND = "END";
    public static final String ADD_TEAM_COMMAND = "Team";
    public static final String ADD_PLAYER_COMMAND = "Add";
    public static final String REMOVE_PLAYER_COMMAND = "Remove";
    public static final String GET_TEAM_RATING_COMMAND = "Rating";
    public static final String TOKENS_SPLIT_REGEX = ";";
    public static final int COMMAND_INDEX = 0;
    public static final int TEAM_NAME_INDEX = 1;
    public static final int PLAYER_NAME_INDEX = 2;
    public static final int ENDURANCE_INDEX = 3;
    public static final int SPRINT_INDEX = 4;
    public static final int DRIBBLE_INDEX = 5;
    public static final int PASSING_INDEX = 6;
    public static final int SHOOTING_INDEX = 7;

    private Config() {
    }
}
