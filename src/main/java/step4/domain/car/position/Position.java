package step4.domain.car.position;

import step4.exception.position.PositionNotPositiveException;

import java.util.Objects;

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

    public final int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
