package step3.service;

import java.util.Random;

public final class MovementConditionProvider {

    private final static int BOUND = 10;

    private final static MovementConditionProvider instance = new MovementConditionProvider();

    private MovementConditionProvider() {
    }

    public final static MovementConditionProvider getInstance() {
        return instance;
    }

    public final int makeMovementCondition() {
        final Random randomNumberProvider = new Random();
        final int movementCondition = randomNumberProvider.nextInt(BOUND);
        return movementCondition;
    }
}