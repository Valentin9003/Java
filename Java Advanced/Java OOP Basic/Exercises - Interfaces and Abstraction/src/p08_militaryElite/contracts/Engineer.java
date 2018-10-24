package p08_militaryElite.contracts;

import java.util.List;

public interface Engineer extends SpecialisedSoldier {

    List<Repair> getRepairs();
}
