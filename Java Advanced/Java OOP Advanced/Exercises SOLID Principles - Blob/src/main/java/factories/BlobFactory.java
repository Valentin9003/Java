package factories;

import interfaces.Attack;
import interfaces.Behavior;
import models.Blob;
import observers.Subject;

public class BlobFactory {

    public static Blob create(String name,
                              int health,
                              int damage,
                              Behavior behavior,
                              Attack attack,
                              Subject subject) {
        return new Blob(name, health, damage, behavior, attack, subject);
    }
}
