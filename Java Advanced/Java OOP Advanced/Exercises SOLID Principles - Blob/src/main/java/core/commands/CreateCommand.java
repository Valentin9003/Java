package core.commands;

import annotations.Inject;
import factories.AttackFactory;
import factories.BehaviorFactory;
import factories.BlobFactory;
import interfaces.Attack;
import interfaces.Behavior;
import interfaces.Executable;
import models.Blob;
import observers.Subject;
import repositories.interfaces.Repository;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> repository;

    @Inject
    private Subject subject;

    @Override
    public void execute() {
        String name = data[0];
        int health = Integer.parseInt(data[1]);
        int damage = Integer.parseInt(data[2]);
        String behaviorType = this.data[3];
        String attackType = this.data[4];

        Behavior behavior = BehaviorFactory.create(behaviorType);
        Attack attack = AttackFactory.create(attackType);

        Blob blob = BlobFactory.create(name, health, damage, behavior, attack, this.subject);

        this.repository.add(blob);
    }
}
