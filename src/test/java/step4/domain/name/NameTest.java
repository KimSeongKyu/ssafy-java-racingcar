package step4.domain.name;

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

    static Stream<Arguments> provideNameAsStringForConstructThrowExceptionTest() {
        return Stream.of(
                Arguments.of(null, new NameNullPointerException()),
                Arguments.of("", new EmptyNameException()),
                Arguments.of("KimSeongKyu", new NameLengthOutOfBoundException())
        );
    }

    @DisplayName(value = "문자열 이름을 멤버 변수로 갖는 객체 생성 테스트")
    @Test
    void constructTest() {
        // given
        String nameAsString = "kim";

        // when
        Name name = new Name(nameAsString);

        // then
        assertThat(name).isNotNull();
    }

    @DisplayName(value = "String형 이름이 null, 빈 문자열, 혹은 5글자 초과인 경우 생성 시 예외가 발생하는 테스트")
    @ParameterizedTest(name = "{index}. 이름: {0} 발생하는 예외: {1}")
    @MethodSource(value = "provideNameAsStringForConstructThrowExceptionTest")
    void constructThrowExceptionTest(String name, RuntimeException exception) {
        // when and then
        assertThatExceptionOfType(exception.getClass()).isThrownBy(() -> {
            new Name(name);
        });
    }

    @DisplayName(value = "생성 시 파라미터로 받은 문자열을 멤버 변수로 갖는지 확인하는 테스트")
    @Test
    void valueTest() {
        // given
        Name name = new Name("kim");
        String expectedResult = "kim";

        // when
        String nameValue = name.value();

        // then
        assertThat(nameValue).isEqualTo(expectedResult);
    }
}