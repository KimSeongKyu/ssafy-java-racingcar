package step4.domain.car.name;

import step4.exception.name.NameLengthOutOfBoundException;
import step4.exception.name.NameNullPointerException;

import java.util.Objects;

public final class Name {

    private final static int BOUND = 5;

    private final String name;

    public Name(final String name) {
        validateNameIsNull(name);
        validateNameLengthInBound(name);
        this.name = name;
    }

    private final void validateNameIsNull(final String name) {
        if (Objects.isNull(name)) {
            throw new NameNullPointerException();
        }
    }

    private final void validateNameLengthInBound(final String name) {
        if (name.isEmpty() || name.length() > BOUND) {
            throw new NameLengthOutOfBoundException();
        }
    }

    public final String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
