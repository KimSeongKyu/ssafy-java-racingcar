package step4.domain.car.position;

import step4.exception.position.PositionNotPositiveException;

import java.util.Objects;

public final class Position {

    private final static int CRITERION_FOR_POSITIVE_NUMBER = 1;

    private final int position;

    public Position(final int position) {
        validatePositionIsPositive(position);
        this.position = position;
    }

    private final void validatePositionIsPositive(final int position) {
        if (position < CRITERION_FOR_POSITIVE_NUMBER) {
            throw new PositionNotPositiveException();
        }
    }

    public final int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
