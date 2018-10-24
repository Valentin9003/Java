package interfaces;

import models.Blob;

public interface Behavior {

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();

    boolean toDelayRecurrentEffect();
}
