package entity.carsDto;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand,
               String model,
               int yearOfProduction,
               int horsepower,
               int acceleration,
               int suspension,
               int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public int getOverallPerformance() {
        return (this.getHorsepower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    public int getEnginePerformance() {
        return this.getHorsepower() / this.getAcceleration();
    }

    public int getSuspensionPerformance() {
        return this.getSuspension() + this.getDurability();
    }

    public int getTimePerformance(int raceLength) {
        return raceLength * (this.getHorsepower() / 100) * this.getAcceleration();
    }

    public void tune(int tuneIndex, String tuneAddOn) {
        this.horsepower += tuneIndex;
        this.suspension += tuneIndex / 2;
    }

    public void decreaseDurability(int dur) {
        this.durability -= dur;
    }

    @Override
    public String toString() {
        //o	“{brand} {model} {yearOfProduction}
        //o	 {horsepower} HP, 100 m/h in {acceleration} s
        //o	 {suspension} Suspension force, {durability} Durability”
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d",
                this.getBrand(),
                this.getModel(),
                this.getYearOfProduction()))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s",
                        this.getHorsepower(),
                        this.getAcceleration()))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability",
                        this.getSuspension(),
                        this.getDurability()));

        return sb.toString();
    }
}
