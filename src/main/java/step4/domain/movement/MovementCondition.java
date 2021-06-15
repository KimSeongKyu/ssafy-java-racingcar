package step4.domain.movement;

import java.util.Random;

public final class MovementCondition {

    private final static Random randomValue = new Random();

    public final static int generateRandomValueInBound(final int bound) {
        return randomValue.nextInt(bound);
    }
}
