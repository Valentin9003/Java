package models.races;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;
import contracts.Race;
import exeptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements Race {

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        } else if (!this.getAllowsMotorboats() && boat.isMotorBoat()) {
            return;
        }

        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}