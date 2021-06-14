package step4.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.name.NamesEmptyException;
import step4.exception.name.NamesNullPointerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NamesTest {

    static Stream<Arguments> provideNullAndEmptyListForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, NamesNullPointerException.class),
                Arguments.of(new ArrayList<String>(), NamesEmptyException.class)
        );
    }

    @DisplayName(value = "이름 리스트를 갖는 생성 테스트")
    @Test
    void constructTest() {
        // given
        List<String> namesAsString = Arrays.stream(new String[]{"name", "for", "test"}).collect(Collectors.toList());

        // when
        Names names = new Names(namesAsString);

        // then
        assertThat(names).isNotNull();
    }


    @DisplayName(value = "null 혹은 빈 리스트를 파라미터로 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 리스트: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideNullAndEmptyListForConstructThrowExceptionTest")
    void constructThrowExceptionTest(List<String> names, Class exception) {
        // when and then
        assertThatExceptionOfType(exception).isThrownBy(() -> new Names(names));
    }
}