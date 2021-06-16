package step4.domain.car;

import step4.domain.car.name.Name;
import step4.domain.car.position.Position;
import step4.exception.name.NameNullPointerException;
import step4.exception.position.PositionNullPointerException;
import step4.strategy.MovementStrategy;

import java.util.Objects;

public final class Car {

    public final static int START_POSITION = 1;

    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this(name, new Position(START_POSITION));
    }

    public Car(final Name name, final Position position) {
        validateNameIsNull(name);
        validatePositionIsNull(position);
        this.name = name;
        this.position = position;
    }

    private final void validateNameIsNull(final Name name) {
        if (Objects.isNull(name)) {
            throw new NameNullPointerException();
        }
    }

    private final void validatePositionIsNull(final Position position) {
        if (Objects.isNull(position)) {
            throw new PositionNullPointerException();
        }
    }

    public final Car move(final MovementStrategy movementStrategy) {
        return movementStrategy.isMovable() ? new Car(name, new Position(position.value() + 1)) : this;
    }

    public final Name name() {
        return name;
    }

    public final Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
