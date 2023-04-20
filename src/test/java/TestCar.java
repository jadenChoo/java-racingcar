import CarRacing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCar {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("차량 생성 시 초기 위치는 1")
    public void car_initial_position() {
        int expected = 1;

        int actual = car.currentPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 생성 시 position도 입력받으면 해당 position을 가진다")
    public void car_with_position() {
        int expected = 6;

        Car car = new Car("fini");
        car.move(5);

        int actual = car.currentPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 이동 시 현재 위치에 입력된 수만큼 더해진다")
    public void car_move() {
        int input = 3;
        int expected = 4;

        car.move(input);
        int actual = car.currentPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 생성 시 이름을 입력받는다")
    public void car_name() {
        String expected = "pobi";

        String actual = car.name();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차량 이름 길이가 5자 초과하면 IlligalArgumentException 발생")
    public void car_name_above_5() {
        assertThatThrownBy(() -> new Car("bbbbbbbb"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
