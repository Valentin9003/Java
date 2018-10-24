package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.annotations.Inject;

public class AddCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private UnitFactory unitFactory;

    @Inject
    private Repository repository;

    public AddCommand() {
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
