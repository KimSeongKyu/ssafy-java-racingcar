package step3.service;

public final class MovementDecisionMaker {

    private final static int CRITERION_TO_MOVE = 4;
    private final static boolean IS_MOVABLE = true;
    private final static boolean IS_NOT_MOVABLE = false;

    private MovementDecisionMaker() {
    }

    public final static MovementDecisionMaker getInstance() {
        return MovementDecisionMakerHolder.instance;
    }

    public final boolean decideMovement(final int conditionToMove) {
        if (conditionToMove >= CRITERION_TO_MOVE) {
            return IS_MOVABLE;
        }
        return IS_NOT_MOVABLE;
    }

    private final static class MovementDecisionMakerHolder {
        private final static MovementDecisionMaker instance = new MovementDecisionMaker();
    }
}
