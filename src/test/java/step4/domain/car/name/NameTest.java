package step4.domain.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.exception.name.NameLengthOutOfBoundException;
import step4.exception.name.NameNullPointerException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    static Stream<Arguments> provideNameForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new NameNullPointerException()),
                Arguments.of("", new NameLengthOutOfBoundException()),
                Arguments.of("KimSeongKyu", new NameLengthOutOfBoundException())
        );
    }

    @DisplayName(value = "생성 테스트")
    @Test
    void constructTest() {
        // given
        String name = "kim";

        // when
        Name resultName = new Name(name);

        // then
        assertThat(resultName).isNotNull();
    }

    @DisplayName(value = "String형 이름이 null 혹은 글자 수가 범위를 벗어난 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. String형 이름: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideNameForConstructThrowExceptionTest")
    void constructThrowExceptionTest(String name, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            new Name(name);
        });
    }

    @DisplayName(value = "String형 이름을 반환하는 테스트")
    @Test
    void nameTest() {
        // given
        String expectedName = "kim";
        Name name = new Name(expectedName);

        // when
        String resultName = name.name();

        // then
        assertThat(resultName).isEqualTo(expectedName);
    }
}