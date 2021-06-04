package step3.service;

import java.util.Random;

public final class MovementConditionProvider {

    private final static int BOUND = 10;

    private MovementConditionProvider() {
    }

    public final static MovementConditionProvider getInstance() {
        return MovementConditionProviderHolder.instance;
    }

    public final int makeMovementCondition() {
        final Random randomNumberProvider = new Random();
        final int movementCondition = randomNumberProvider.nextInt(BOUND);
        return movementCondition;
    }

    private final static class MovementConditionProviderHolder {
        private final static MovementConditionProvider instance = new MovementConditionProvider();
    }

}