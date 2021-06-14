package step4.domain.name;

import step4.exception.NamesEmptyException;
import step4.exception.NamesNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Names {

    private final List<Name> names;

    public Names(final List<String> namesAsString) {
        validateNamesAreNull(namesAsString);
        validateNamesAreEmpty(namesAsString);
        this.names = createNames(namesAsString);
    }

    private final List<Name> createNames(final List<String> namesAsString) {
        List<Name> names = new ArrayList<>();
        namesAsString.stream().forEachOrdered(name -> names.add(new Name(name)));
        return names;
    }

    private final void validateNamesAreNull(final List<String> namesAsString) {
        if (Objects.isNull(namesAsString)) {
            throw new NamesNullPointerException();
        }
    }

    private final void validateNamesAreEmpty(final List<String> namesAsString) {
        if(namesAsString.isEmpty()) {
            throw new NamesEmptyException();
        }
    }
}
