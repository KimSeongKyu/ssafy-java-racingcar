package step3.domain.car;

import step3.domain.strategy.movement.MovementStrategy;

public final class Car {

    public final static int START_POSITION = 1;

    private int position;

    public Car() {
        position = START_POSITION;
    }

    private Car(final int position) {
        this.position = position;
    }

    public final Car move(final int movementStrategyNumber, final MovementStrategy movementStrategy) {
        if (movementStrategy.isMovable(movementStrategyNumber)) {
            return new Car(++position);
        }
        return this;
    }

    public final int getPosition() {
        return position;
    }
}

