package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.core.annotations.Inject;

public class RetireCommand implements Executable {

    private final String UNIT_RETIRED_MSG = "%s retired!";

    @Inject
    private String[] data;

    @Inject
    private Repository repository;

    public RetireCommand() {
    }

    @Override
    public String execute() {
        String unitType = this.data[1];

        try {
            this.repository.removeUnit(unitType);
        } catch (IllegalArgumentException iae) {
            return iae.getLocalizedMessage();
        }
        return String.format(UNIT_RETIRED_MSG, unitType);
    }
}
