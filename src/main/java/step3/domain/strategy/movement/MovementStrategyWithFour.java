package step3.domain.strategy.movement;

public final class MovementStrategyWithFour implements MovementStrategy {

    private final static int CRITERION_TO_MOVE = 4;
    private final static boolean IS_MOVABLE = true;
    private final static boolean IS_NOT_MOVABLE = false;

    private MovementStrategyWithFour() {
    }

    public final static MovementStrategyWithFour getInstance() {
        return MovementStrategyWithFourHolder.INSTANCE;
    }

    @Override
    public final boolean isMovable(final int movementStrategyNumber) {
        if (movementStrategyNumber >= CRITERION_TO_MOVE) {
            return IS_MOVABLE;
        }
        return IS_NOT_MOVABLE;
    }

    private final static class MovementStrategyWithFourHolder {
        private final static MovementStrategyWithFour INSTANCE = new MovementStrategyWithFour();
    }
}
