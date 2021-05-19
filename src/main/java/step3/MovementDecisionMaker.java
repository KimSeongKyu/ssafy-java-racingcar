package step3;

public final class MovementDecisionMaker {

    private final static int CRITERION_TO_MOVE = 4;
    private final static boolean IS_MOVABLE = true;
    private final static boolean IS_NOT_MOVABLE = false;

    private MovementDecisionMaker() {
    }


    public final static boolean decideMovement(final int conditionToMove) {
        if(conditionToMove >= CRITERION_TO_MOVE) {
            return IS_MOVABLE;
        }
        return IS_NOT_MOVABLE;
    }
}
