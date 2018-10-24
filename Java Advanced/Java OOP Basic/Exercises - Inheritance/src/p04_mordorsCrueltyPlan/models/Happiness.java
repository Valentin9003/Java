package p04_mordorsCrueltyPlan.models;

import p04_mordorsCrueltyPlan.models.util.ConfigMood;

public class Happiness {

    private int happiness;

    public Happiness(int happiness) {
        this.setHappiness(happiness);
    }

    public int getHappiness() {
        return happiness;
    }

    private void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void addHappiness(int happinessPT) {
        this.happiness += happinessPT;
    }

    public String getMood() {
        return this.getHappiness() < ConfigMood.ANGRY_BELOW_PT ? ConfigMood.ANGRY :
                    this.getHappiness() <= ConfigMood.SAD_BELOW_PT ? ConfigMood.SAD :
                        this.getHappiness() <= ConfigMood.HAPPY_BELOW_PT ? ConfigMood.HAPPY :
                                ConfigMood.JAVA_SCRIPT;
    }
}
