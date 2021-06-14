package step4.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}