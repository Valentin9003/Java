package p03_wildFarm.models.animalModels;

import p03_wildFarm.util.ConfigConstants;
import p03_wildFarm.util.ConfigExMessage;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private static final String DEFAULT_SOUND = "Meowwww";

    private String breed;

    public Cat(String name, double weight, String livingRegion, String breed) {
        super(name, weight, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException(ConfigExMessage.EMPTY_CAT_BREED_EX_MESSAGE);
        }
        this.breed = breed;
    }

    private String getBreed() {
        return this.breed;
    }

    @Override
    public String makeSound() {
        return DEFAULT_SOUND;
    }

    @Override
    public String toString() {
//        {AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]
        return String.format(ConfigConstants.CAT_TO_STRING_PATTERN,
                this.getClass().getSimpleName(),
                this.getName(),
                this.getBreed(),
                new DecimalFormat(ConfigConstants.DECIMAL_FORMAT_PATTERN).format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
