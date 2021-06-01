package step3.domain;

import java.util.ArrayList;
import java.util.List;

public final class CarFactory {

    private final static List<Car> cars = new ArrayList<>();

    private CarFactory() {
    }

    public final static List<Car> createCars(final int numberOfCars) {
        for(int numberOfCreatedCars = 0; numberOfCreatedCars < numberOfCars; numberOfCreatedCars++) {
            final Car car = new Car();
            cars.add(car);
        }
        return cars;
    }
}
