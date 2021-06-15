package step4.domain.car;

import step4.domain.name.Name;

public final class Car {

    private final static int START_POSITION = 1;

    private final Name name;
    private final int position;

    public Car(final Name name) {
        this.name = name;
        this.position = START_POSITION;
    }
}
