package step3.domain.car;

import java.util.ArrayList;
import java.util.List;

public final class Cars {

    private final static int ONE = 1;
    private final List<Car> cars;

    public Cars(final NumberOfCars numberOfCars) {
        this(createCars(numberOfCars));
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private final static List<Car> createCars(final NumberOfCars numberOfCars) {
        final List<Car> cars = new ArrayList<>();
        for (int createdNumberOfCars = ONE; createdNumberOfCars <= numberOfCars.getNumberOfCars(); createdNumberOfCars++) {
            cars.add(new Car());
        }
        return cars;
    }

    public final List<Car> getCars() {
        return cars;
    }
}
