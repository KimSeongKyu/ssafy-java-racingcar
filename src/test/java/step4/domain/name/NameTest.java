package step4.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.NameLengthOutOfBoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

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

    @DisplayName(value = "문자열의 길이가 5 초과인 경우 생성 시 예외가 발생하는 테스트")
    @Test
    void constructThrowExceptionTest() {
        // given
        String nameWithLengthLongerThanFive = "kimSeongKyu";

        // when and then
        assertThatExceptionOfType(NameLengthOutOfBoundException.class).isThrownBy(() -> {
            new Name(nameWithLengthLongerThanFive);
        });
    }

    @DisplayName(value = "생성 시 파라미터로 받은 문자열을 멤버 변수로 갖는지 확인하는 테스트")
    @Test
    void nameTest() {
        // given
        Name name = new Name("kim");
        String expectedResult = "kim";

        // when
        String nameAsString = name.name();

        // then
        assertThat(nameAsString).isEqualTo(expectedResult);
    }
}