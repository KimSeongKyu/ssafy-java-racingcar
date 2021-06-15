package step4.domain.car;

import step4.domain.name.Name;
import step4.exception.name.NameNullPointerException;

import java.util.Objects;

public final class Car {

    private final static int START_POSITION = 1;

    private final Name name;
    private final int position;

    public Car(final Name name) {
        validateNameIsNull(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private final void validateNameIsNull(final Name name) {
        if (Objects.isNull(name)) {
            throw new NameNullPointerException();
        }
    }

    public final Name name() {
        return name;
    }
}
