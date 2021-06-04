package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName(value = "사용자로부터 입력 받은 수 만큼의 차량 생성 테스트")
    @Test
    void createCarsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        int numberOfCars = 3;
        Method method = Cars.class.getDeclaredMethod("createCars", int.class);
        method.setAccessible(true);

        // when
        List<Car> cars = (List<Car>) method.invoke(null, numberOfCars);

        // then
        assertThat(cars.size()).isEqualTo(numberOfCars);
    }
}