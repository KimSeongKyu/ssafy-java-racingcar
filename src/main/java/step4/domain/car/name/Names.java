package step4.domain.car.name;

import step4.exception.name.EmptyNamesException;
import step4.exception.name.NamesNullPointerException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Names {

    private final List<Name> values;

    public Names(final List<String> names) {
        validateNamesAreNull(names);
        validateNamesAreEmpty(names);
        values = createNames(names);
    }

    private final List<Name> createNames(final List<String> names) {
        return names.stream()
                .map(name -> new Name(name))
                .collect(Collectors.toList());
    }

    private final void validateNamesAreNull(final List<String> names) {
        if (Objects.isNull(names)) {
            throw new NamesNullPointerException();
        }
    }

    private final void validateNamesAreEmpty(final List<String> names) {
        if (names.isEmpty()) {
            throw new EmptyNamesException();
        }
    }

    public final List<Name> values() {
        return values;
    }
}
