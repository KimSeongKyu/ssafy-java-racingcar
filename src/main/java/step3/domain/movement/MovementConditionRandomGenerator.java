package step3.domain.movement;

import java.util.Random;

public final class MovementConditionRandomGenerator {

    private final static int BOUND = 10;

    private final static Random randomNumberProvider = new Random();

    private MovementConditionRandomGenerator() {
    }

    public final static int generateRandomMovementCondition() {
        return randomNumberProvider.nextInt(BOUND);
    }
}