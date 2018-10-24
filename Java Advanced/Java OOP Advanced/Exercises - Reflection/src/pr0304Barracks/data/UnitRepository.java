package pr0304Barracks.data;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	private final String NO_SUCH_UNIT_EXCEPTION_MSG = "No such units in repository.";

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType) {
		// TODO: implement for problem 4 ==> READY!!!
		if (!this.amountOfUnits.containsKey(unitType) ||
				this.amountOfUnits.get(unitType) == 0) {
			throw new IllegalArgumentException(NO_SUCH_UNIT_EXCEPTION_MSG);
		}

		int newAmount = this.amountOfUnits.get(unitType) - 1;
		this.amountOfUnits.replace(unitType, newAmount);
	}
}
