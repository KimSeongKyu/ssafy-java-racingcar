package step3.service;

import java.util.Random;

public final class MovementConditionProvider {

    private final static int BOUND = 10;

    private final static Random randomNumberProvider = new Random();

    private MovementConditionProvider() {
    }

    public final static int makeMovementCondition() {
        return randomNumberProvider.nextInt(BOUND);
    }
}