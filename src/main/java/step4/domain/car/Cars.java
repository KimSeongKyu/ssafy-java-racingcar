package step4.domain.car;

import step4.domain.name.Name;
import step4.domain.name.Names;

import java.util.ArrayList;
import java.util.List;

public final class Cars {

    private final List<Car> cars;

    public Cars(final Names names) {
        this(names.names());
    }

    public Cars(final List<Name> names) {
        this.cars = createCars(names);
    }

    private final List<Car> createCars(final List<Name> names) {
        List<Car> cars = new ArrayList<>();
        names.stream().forEachOrdered(name -> cars.add(new Car(name)));
        return cars;
    }

    public final List<Car> cars() {
        return cars;
    }
}
