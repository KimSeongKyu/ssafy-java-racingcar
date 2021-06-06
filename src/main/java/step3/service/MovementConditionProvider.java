package step3.service;

import java.util.Random;

public final class MovementConditionProvider {

    private final static int BOUND = 10;

    private final Random randomNumberProvider;

    private MovementConditionProvider() {
        randomNumberProvider = new Random();
    }

    public final static MovementConditionProvider getInstance() {
        return MovementConditionProviderHolder.instance;
    }

    public final int makeMovementCondition() {
        return randomNumberProvider.nextInt(BOUND);
    }

    private final static class MovementConditionProviderHolder {
        private final static MovementConditionProvider instance = new MovementConditionProvider();
    }

}