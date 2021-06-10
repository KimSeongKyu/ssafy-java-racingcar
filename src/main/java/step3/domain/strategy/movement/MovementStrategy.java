package step3.domain.strategy.movement;

@FunctionalInterface
public interface MovementStrategy {
    boolean isMovable(final int movementStrategyNumber);
}
