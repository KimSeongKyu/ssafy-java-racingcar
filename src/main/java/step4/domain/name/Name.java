package step4.domain.name;

import step4.exception.NameLengthOutOfBoundException;

public final class Name {

    private final static int BOUND = 5;

    private final String name;

    public Name(final String name) {
        validateNameLengthInBound(name);
        this.name = name;
    }

    private final void validateNameLengthInBound(final String name) {
        if (name.length() > BOUND) {
            throw new NameLengthOutOfBoundException();
        }
    }

    public final String name() {
        return name;
    }
}
