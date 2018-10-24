package p03_coffeeMachine;

public class Coffee {

    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(String type, String size) {
        this.setType(type);
        this.setSize(size);
    }

    private void setType(String type) {
        if (!enumContains(type, CoffeeType.values())) {
            throw new IllegalArgumentException("Wrong coffee type");
        }
        this.type = Enum.valueOf(CoffeeType.class, type.toUpperCase());
    }

    private void setSize(String size) {
        if (!enumContains(size, CoffeeSize.values())) {
            throw new IllegalArgumentException("Wrong coffee size");
        }
        this.size = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
    }

    private <T> boolean enumContains(String type, T[] values) {
        for (T value : values) {
            if (value.toString().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

    public CoffeeType getType() {
        return this.type;
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.size.toString(), this.type.toString());
    }
}
