package step3.domain.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberOfCarsOutOfBoundExceptionTest {

    @DisplayName("생성 시 예외 발생 테스트")
    @Test
    void ConstructorTest() {
        // given when then
        assertThatExceptionOfType(NumberOfCarsOutOfBoundException.class).isThrownBy(() -> {
            throw new NumberOfCarsOutOfBoundException();
        });
    }
}