import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 크기를 확인하는 테스트")
    @Test
    void getSizeTest() {
        // given
        int expectedSetSize = 3;

        // when
        int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(expectedSetSize);
    }

    @DisplayName("Set이 1,2,3을 원소로 갖는지 확인하는 테스트")
    @ParameterizedTest(name = "{index}. Set이 {0}를 원소로 갖는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containOneTwoThreeTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set이 입력값을 원소로 가지면 true, 갖지 않으면 false를 반환하는지 확인하는 테스트")
    @ParameterizedTest(name = "{index}. Set이 입력값 {0}에 대해 올바른 결과를 반환하는지 확인하는 테스트")
    @CsvSource(value = {"0,false","1,true", "2,true", "3,true", "4,false"})
    void containTest(int number, boolean expectedResult) {
        assertThat(numbers.contains(number)).isEqualTo(expectedResult);
    }
}
