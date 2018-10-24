package models.behavors;

import interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    protected AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    @Override
    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
