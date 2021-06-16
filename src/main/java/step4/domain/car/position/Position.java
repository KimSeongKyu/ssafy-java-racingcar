package step4.domain.car.position;

import step4.exception.position.PositionNotPositiveException;

public final class Position {

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;

    private final int value;

    public Position(final int position) {
        validatePositionIsPositive(position);
        value = position;
    }

    private final void validatePositionIsPositive(final int position) {
        if (position < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new PositionNotPositiveException();
        }
    }
}
