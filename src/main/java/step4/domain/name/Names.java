package step4.domain.name;

import step4.exception.name.NamesAsStringEmptyException;
import step4.exception.name.NamesAsStringNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Names {

    private final List<Name> names;

    public Names(final List<String> namesAsString) {
        validateNamesAsStringAreNull(namesAsString);
        validateNamesAsStringAreEmpty(namesAsString);
        this.names = createNames(namesAsString);
    }

    private final List<Name> createNames(final List<String> namesAsString) {
        List<Name> names = new ArrayList<>();
        namesAsString.stream().forEachOrdered(name -> names.add(new Name(name)));
        return names;
    }

    private final void validateNamesAsStringAreNull(final List<String> namesAsString) {
        if (Objects.isNull(namesAsString)) {
            throw new NamesAsStringNullPointerException();
        }
    }

    private final void validateNamesAsStringAreEmpty(final List<String> namesAsString) {
        if(namesAsString.isEmpty()) {
            throw new NamesAsStringEmptyException();
        }
    }

    public final List<Name> names() {
        return names;
    }
}
