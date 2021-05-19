package step3;

import java.util.Random;

public final class MovementConditionProvider {

    private final static int BOUND = 10;

    public final static int makeMovementCondition() {
        final Random randomNumberProvider = new Random();
        final int movementCondition = randomNumberProvider.nextInt(BOUND);
        return movementCondition;
    }
}