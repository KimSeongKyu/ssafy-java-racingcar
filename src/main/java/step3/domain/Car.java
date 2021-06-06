package step3.domain;

public final class Car {

    private final static int START = 1;

    private int position;

    public Car() {
        position = START;
    }

    public final void move(final boolean isMovable) {
        if (isMovable) {
            ++position;
        }
    }

    public final int getPosition() {
        return position;
    }
}

