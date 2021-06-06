package step3.domain;

public final class Car {

    public final static int START_POSITION = 1;

    private int position;

    public Car() {
        position = START_POSITION;
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

