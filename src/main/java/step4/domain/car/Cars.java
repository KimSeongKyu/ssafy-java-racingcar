package step4.domain.car;

import step4.domain.name.Name;
import step4.domain.name.Names;

import java.util.ArrayList;
import java.util.List;

public final class Cars {

    private final List<Car> values;

    public Cars(final Names names) {
        this(createCars(names.values()));
    }

    public Cars(final List<Car> cars) {
        values = cars;
    }

    private final static List<Car> createCars(final List<Name> names) {
        List<Car> cars = new ArrayList<>();
        names.stream().forEachOrdered(name -> cars.add(new Car(name)));
        return cars;
    }

    public final List<Car> values() {
        return values;
    }
}
