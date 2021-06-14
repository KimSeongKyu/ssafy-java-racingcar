package step4.domain.name;

import java.util.ArrayList;
import java.util.List;

public final class Names {

    private final List<Name> names;

    public Names(final List<String> namesAsString) {
        this.names = createNames(namesAsString);
    }

    private final List<Name> createNames(final List<String> namesAsString) {
        List<Name> names = new ArrayList<>();
        namesAsString.stream().forEachOrdered(name -> names.add(new Name(name)));
        return names;
    }
}
