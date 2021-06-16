package step4.domain.name;

import step4.exception.name.NameLengthOutOfBoundException;

import java.util.Objects;

public final class Name {

    private final static int BOUND = 5;

    private final String value;

    public Name(final String name) {
        validateNameLengthInBound(name);
        value = name;
    }

    private final void validateNameLengthInBound(final String name) {
        if (name.length() > BOUND) {
            throw new NameLengthOutOfBoundException();
        }
    }

    public final String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
