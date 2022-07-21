package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallNumberTest {

    @Test
    @DisplayName("볼 숫자는 1 ~ 9까지만 가능하다.")
    void validate() {
        assertThat(new BallNumber(1)).isNotNull();
        assertThat(new BallNumber(9)).isNotNull();

        assertThatThrownBy(() -> new BallNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BallNumber(10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메서드를 호출할 때마다, 1 ~ 9까지 숫자를 랜덤하게 생성한다.")
    void createRandomNumber() {
        BallNumber first = BallNumber.createRandom();
        BallNumber second = BallNumber.createRandom();

        assertThat(first).isNotEqualTo(second);
    }
}
