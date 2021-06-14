package step4.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

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
}