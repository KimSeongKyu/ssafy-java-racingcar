package step4.domain.movement;

import java.util.Random;

public final class MovementCondition {

    private final static Random randomNumber = new Random();

    public final static int generateRandomNumberInBound(final int bound) {
        return randomNumber.nextInt(bound);
    }
}
