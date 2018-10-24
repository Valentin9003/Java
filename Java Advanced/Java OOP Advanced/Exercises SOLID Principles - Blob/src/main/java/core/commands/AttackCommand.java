package core.commands;

import annotations.Inject;
import interfaces.Executable;
import models.Blob;
import repositories.interfaces.Repository;

public class AttackCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> repository;

    @Override
    public void execute() {
        String attackerName = this.data[0];
        String targetName = this.data[1];

        Blob attacker = this.repository.findByName(attackerName);
        Blob target = this.repository.findByName(targetName);

        attacker.attack(target);
    }
}
