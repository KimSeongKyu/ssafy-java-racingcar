package step3;

public final class Car {

    private final StringBuilder position;

    public Car() {
        position = new StringBuilder("-");
    }

    public final void move(final boolean isMovable) {
        if (isMovable) {
            position.append("-");
        }
    }

    public String getPosition() {
        return position.toString();
    }
}

