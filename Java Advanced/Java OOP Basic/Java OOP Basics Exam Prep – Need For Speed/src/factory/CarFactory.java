package factory;

import entity.carsDto.Car;
import entity.carsDto.PerformanceCar;
import entity.carsDto.ShowCar;

public final class CarFactory {

    private CarFactory() {
    }

    public static Car creatCar(String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;

        switch (type){
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }

        return car;
    }
}
