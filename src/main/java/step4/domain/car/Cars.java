package step4.domain.car;

import step4.domain.car.name.Name;
import step4.domain.car.name.Names;
import step4.exception.car.CarsNullPointerException;
import step4.strategy.MovementStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Cars {

    private final List<Car> cars;

    public Cars(final Names names) {
        this(createCars(names.names()));
    }

    public Cars(final List<Car> cars) {
        validateCarsAreNull(cars);
        this.cars = cars;
    }

    private final static List<Car> createCars(final List<Name> names) {
        return names.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toUnmodifiableList());
    }

    private final void validateCarsAreNull(final List<Car> cars) {
        if (Objects.isNull(cars)) {
            throw new CarsNullPointerException();
        }
    }

    public final Cars move(final MovementStrategy movementStrategy) {
        return new Cars(cars.stream()
                .map(car -> car.move(movementStrategy))
                .collect(Collectors.toList()));
    }

    public final Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(this.cars, cars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
