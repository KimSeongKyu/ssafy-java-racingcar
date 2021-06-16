package step4.domain.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.name.EmptyNamesException;
import step4.exception.name.NamesNullPointerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NamesTest {

    static Stream<Arguments> provideNullAndEmptyListForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new NamesNullPointerException()),
                Arguments.of(new ArrayList<String>(), new EmptyNamesException())
        );
    }

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        List<String> namesValues = Arrays.asList(new String[]{"name", "for", "test"});

        // when
        Names resultNames = new Names(namesValues);

        // then
        assertThat(resultNames).isNotNull();
    }

    @DisplayName(value = "String형 이름 리스트가 null 혹은 빈 리스트일 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. String형 이름 리스트: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideNullAndEmptyListForConstructThrowExceptionTest")
    void constructThrowExceptionTest(List<String> namesValues, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> new Names(namesValues));
    }

    @DisplayName(value = "Name 리스트를 반환하는 테스트")
    @Test
    void valuesTest() {
        // given
        List<Name> expectedNamesValues = new ArrayList<>();
        expectedNamesValues.add(new Name("name"));
        expectedNamesValues.add(new Name("for"));
        expectedNamesValues.add(new Name("test"));

        Names names = new Names(Arrays.asList(new String[]{"name", "for", "test"}));

        // when
        List<Name> resultNamesValues = names.values();

        // then
        assertThat(resultNamesValues).isEqualTo(expectedNamesValues);
    }
}