package step4.domain.name;

import step4.exception.name.NameLengthOutOfBoundException;

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
}
