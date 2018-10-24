package p03_coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffees;
    private int coinsAmount;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        if (!enumContains(size, CoffeeSize.values())) {
            throw new IllegalArgumentException("Wrong coffee size");
        }
        if (!enumContains(type, CoffeeType.values())) {
            throw new IllegalArgumentException("Wrong coffee type");
        }
        int price = CoffeeSize.valueOf(CoffeeSize.class, size.toUpperCase()).getPrice();
        if (this.coinsAmount >= price) {
            this.coffees.add(new Coffee(type, size));
            this.coinsAmount = 0;
        }
    }

    public void insertCoin(String coin) {
        if (!enumContains(coin, Coin.values())) {
            throw new IllegalArgumentException("Machine doesn't work with this type of coins");
        }
        this.coinsAmount += Enum.valueOf(Coin.class, coin).getValue();
    }

    private <T> boolean enumContains(String coin, T[] values) {
        for (T value : values) {
            if (value.toString().equalsIgnoreCase(coin)) {
                return true;
            }
        }
        return false;
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffees;
    }
}
