package p03_wildFarm.models.animalModels;

import p03_wildFarm.util.ConfigConstants;
import p03_wildFarm.util.ConfigExMessage;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String name, double weight, String livingRegion) {
        super(name, weight);
        this.setLivingRegion(livingRegion);
    }

    private void setLivingRegion(String livingRegion) {
        if (livingRegion == null || livingRegion.trim().isEmpty()) {
            throw new IllegalArgumentException(ConfigExMessage.EMPTY_LIVING_REGION_EX_MESSAGE);
        }
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
//        {AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return String.format(ConfigConstants.MAMMAL_TO_STRING_PATTERN,
                this.getClass().getSimpleName(),
                this.getName(),
                new DecimalFormat(ConfigConstants.DECIMAL_FORMAT_PATTERN).format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
