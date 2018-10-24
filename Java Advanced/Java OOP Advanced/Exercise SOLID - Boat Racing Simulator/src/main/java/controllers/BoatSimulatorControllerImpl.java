package controllers;

import Utility.Constants;
import contracts.*;
import enumeration.EngineType;
import exeptions.*;
import factories.EngineFactory;
import factories.RaceFactory;
import models.boats.*;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {

    private Map<Boat, Double> winners;
    private List<Boat> notFinished;
    private Repository<Boat> boatRepository;
    private Repository<Engine> engineRepository;
    private Race currentRace;

    public BoatSimulatorControllerImpl(Repository<Boat> boatRepo, Repository<Engine> engineRepo) {
        this.boatRepository = boatRepo;
        this.engineRepository = engineRepo;
        this.currentRace = null;
        this.winners = new LinkedHashMap<>();
        this.notFinished = new LinkedList<>();
    }

    private void runRace(List<Boat> participants) {
        for (Boat participant : participants) {
            double speed = participant.calculateRaceSpeed(this.currentRace);
            double time = this.currentRace.getDistance() / speed;

            if (time <= 0) {
                this.notFinished.add(participant);
            } else {
                this.winners.put(participant, time);
            }
        }

        if (this.winners.size() >= 3) {
            this.notFinished.clear();
        }
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        Engine engine = EngineFactory.create(model, horsepower, displacement, engineType);
        this.engineRepository.add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    //TODO: Refactor with Factory pattern
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.boatRepository.add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    //TODO: Refactor with Factory pattern
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.boatRepository.add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    //TODO: Refactor with Factory pattern
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistentModelException, DuplicateModelException {
        Engine firstEngine = this.engineRepository.getItemByModel(firstEngineModel);
        Engine secondEngine = this.engineRepository.getItemByModel(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.boatRepository.add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    //TODO: Refactor with Factory pattern
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistentModelException, DuplicateModelException {
        Engine engine = this.engineRepository.getItemByModel(engineModel);
        Boat boat = new Yacht(model, weight, cargoWeight, engine);
        this.boatRepository.add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorboats) throws RaceAlreadyExistsException {
        this.validateRaceIsEmpty();
        this.currentRace = RaceFactory.create(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);

        return String.format(
                "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                    distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model)
            throws NonExistentModelException, DuplicateModelException, NoSetRaceException {

        this.validateRaceIsSet();
        Boat boat = this.boatRepository.getItemByModel(model);

        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }

        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();

        if (this.currentRace.getParticipants().size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        for (int i = 0; i < 3; i++) {
            runRace(this.currentRace.getParticipants());
        }

        String[] places = {"First", "Second", "Third"};
        final int[] indexPlace = {0};
        StringBuilder result = new StringBuilder();

        this.winners.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(boat -> {
                    if (indexPlace[0] < 3) {
                        result.append(String.format("%s place: %s Model: %s Time: %.2f sec",
                                places[indexPlace[0]++],
                                boat.getKey().getClass().getSimpleName(),
                                boat.getKey().getModel(),
                                boat.getValue()))
                                .append(System.lineSeparator());
                    }
                });

        for (Boat notFinishedBoat : this.notFinished) {
            if (indexPlace[0] == 3) {
                break;
            }
            result.append(String.format("%s place: %s Model: %s Time: Did not finish!",
                    places[indexPlace[0]++],
                    notFinishedBoat.getClass().getSimpleName(),
                    notFinishedBoat.getModel()))
                    .append(System.lineSeparator());
        }

        this.currentRace = null;
        this.winners.clear();
        this.winners = new LinkedHashMap<>();
        this.notFinished.clear();
        this.notFinished = new LinkedList<>();

        return result.toString().trim();
    }

    @Override
    public String getStatistic() {
        //TODO Bonus Task: Implement with stream and using Collectors.groupBy()
        Collection<Boat> participants = this.currentRace.getParticipants();
        int countOfParticipants = participants.size();

        StringBuilder statistic = new StringBuilder();

        participants
                .stream()
                .collect(Collectors.groupingBy((Boat boat) -> boat.getClass().getSimpleName()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(boatsGroup -> {
                    String boatType = boatsGroup.getKey();
                    double percentage = ((double) boatsGroup.getValue().size() / countOfParticipants) * 100;
                    statistic
                            .append(String.format("%s -> %.2f%%", boatType, percentage))
                            .append(System.lineSeparator());
                });

        return statistic.toString().trim();
    }
}
