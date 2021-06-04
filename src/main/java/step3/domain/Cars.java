package step3.domain;

import java.util.List;

public final class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public final List<Car> getCars() {
        return cars;
    }
}
