package step4.domain.winners;

import step4.domain.car.Cars;
import step4.exception.car.CarsNullPointerException;

import java.util.Objects;
import java.util.stream.Collectors;

public final class Winners {

    private final Cars cars;

    public Winners(final Cars cars) {
        validateCarsAreNull(cars);
        this.cars = identifyWinners(cars);
    }

    private final void validateCarsAreNull(final Cars cars) {
        if(Objects.isNull(cars)) {
            throw new CarsNullPointerException();
        }
    }

    private final Cars identifyWinners(final Cars cars) {
        final int winnersPosition = cars.values()
                .stream()
                .mapToInt(car -> car.position().value())
                .max()
                .getAsInt();

        return new Cars(cars.values()
                .stream()
                .filter(car -> Objects.equals(car.position().value(), winnersPosition))
                .collect(Collectors.toList()));
    }

    public final Cars cars() {
        return cars;
    }
}
