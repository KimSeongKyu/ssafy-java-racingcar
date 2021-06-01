package step3.service;

public final class MovementDecisionMaker {

    private final static int CRITERION_TO_MOVE = 4;
    private final static boolean IS_MOVABLE = true;
    private final static boolean IS_NOT_MOVABLE = false;

    private final static MovementDecisionMaker instance = new MovementDecisionMaker();

    private MovementDecisionMaker() {
    }

    public final static MovementDecisionMaker getInstance() {
        return instance;
    }


    public final boolean decideMovement(final int conditionToMove) {
        if (conditionToMove >= CRITERION_TO_MOVE) {
            return IS_MOVABLE;
        }
        return IS_NOT_MOVABLE;
    }
}
