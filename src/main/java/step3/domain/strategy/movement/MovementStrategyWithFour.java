package step3.domain.strategy.movement;

public final class MovementStrategyWithFour implements MovementStrategy {

    private final static int CRITERION_TO_MOVE = 4;

    private MovementStrategyWithFour() {
    }

    public final static MovementStrategyWithFour getInstance() {
        return MovementStrategyWithFourHolder.INSTANCE;
    }

    @Override
    public final boolean isMovable(final int movementStrategyNumber) {
        return movementStrategyNumber >= CRITERION_TO_MOVE;
    }

    private final static class MovementStrategyWithFourHolder {
        private final static MovementStrategyWithFour INSTANCE = new MovementStrategyWithFour();
    }
}
