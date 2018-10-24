package com.company.beerCounter;

public class BeerCounter {

    private static long beerInStock;
    private static long beersDrankCount;

    public BeerCounter() {
    }

    public void buyBeer(long bottlesCount) {
        beerInStock += bottlesCount;
    }

    public void drinkBeer(long bottlesCount) {
        beersDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }

    @Override
    public String toString() {
        return String.format("%d %d", beerInStock, beersDrankCount);
    }
}
