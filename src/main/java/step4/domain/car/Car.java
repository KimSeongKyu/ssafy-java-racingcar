package step4.domain.car;

import step4.domain.car.name.Name;
import step4.exception.name.NameNullPointerException;
import step4.strategy.MovementStrategy;

import java.util.Objects;

public final class Car {

    public final static int START_POSITION = 1;

    private final Name name;
    private final int position;

    public Car(final Name name) {
        this(name, START_POSITION);
    }

    public Car(final Name name, final int position) {
        validateNameIsNull(name);
        this.name = name;
        this.position = position;
    }

    private final void validateNameIsNull(final Name name) {
        if (Objects.isNull(name)) {
            throw new NameNullPointerException();
        }
    }

    public final Name name() {
        return name;
    }

    public final int position() {
        return position;
    }

    public final Car move(final MovementStrategy movementStrategy) {
        return movementStrategy.isMovable() ? new Car(name, position + 1) : this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
