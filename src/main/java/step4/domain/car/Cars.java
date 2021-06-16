package step4.domain.car;

import step4.domain.name.Name;
import step4.domain.name.Names;
import step4.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public final Cars move(final MovementStrategy movementStrategy) {
        return new Cars(values.stream().map(car ->
                car.move(movementStrategy))
                .collect(Collectors.toList()));
    }

    public final List<Car> values() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(values, cars.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
