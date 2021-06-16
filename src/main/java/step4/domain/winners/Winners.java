package step4.domain.winners;

import step4.domain.car.Cars;

import java.util.Objects;
import java.util.stream.Collectors;

public final class Winners {

    private final Cars cars;

    public Winners(final Cars cars) {
        this.cars = identifyWinners(cars);
    }

    private final Cars identifyWinners(final Cars cars) {
        final int winnersPosition = cars.values()
                .stream()
                .mapToInt(car -> car.position())
                .max()
                .getAsInt();

        return new Cars(cars.values()
                .stream()
                .filter(car -> Objects.equals(car.position(), winnersPosition))
                .collect(Collectors.toList()));
    }

    public final Cars cars() {
        return cars;
    }
}
