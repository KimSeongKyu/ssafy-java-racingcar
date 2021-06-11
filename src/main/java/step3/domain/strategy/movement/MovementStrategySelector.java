package step3.domain.strategy.movement;

import step3.domain.exception.IllegalMovementStrategyException;

import java.util.Arrays;

public enum MovementStrategySelector {

    FOUR(4, MovementStrategyWithFour.getInstance());

    private final int movementStrategyNumber;
    private final MovementStrategy movementStrategy;

    MovementStrategySelector(final int movementStrategyNumber, final MovementStrategy movementStrategy) {
        this.movementStrategyNumber = movementStrategyNumber;
        this.movementStrategy = movementStrategy;
    }

    public final static MovementStrategySelector selectMovementStrategy(final int movementStrategyNumber) {
        return Arrays.stream(values())
                .filter(movementStrategySelector -> movementStrategySelector.movementStrategyNumber == movementStrategyNumber)
                .findFirst()
                .orElseThrow(IllegalMovementStrategyException::new);
    }
}
