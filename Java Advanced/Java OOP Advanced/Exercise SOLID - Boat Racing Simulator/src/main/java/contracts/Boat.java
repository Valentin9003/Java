package contracts;

public interface Boat {

    String getModel();

    boolean isMotorBoat();

    double calculateRaceSpeed(Race race);
}
