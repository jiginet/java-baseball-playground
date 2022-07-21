package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    Ball answerBall;

    @BeforeEach
    void setUp() {
        answerBall = new Ball(5, 1);
    }

    @Test
    @DisplayName("숫자와, 위치가 일치 할 경우 STRIKE 를 반환한다.")
    void strike() {
        Ball playerBall = new Ball(5, 1);
        BallState result = answerBall.compare(playerBall);
        assertThat(result).isEqualTo(BallState.STRIKE);
    }

    @Test
    @DisplayName("숫자만 일치하고, 위치가 불일치 할 경우 BALL 을 반환한다.")
    void ball() {
        Ball playerBall = new Ball(5, 2);
        BallState result = answerBall.compare(playerBall);
        assertThat(result).isEqualTo(BallState.BALL);
    }

    @Test
    @DisplayName("숫자와 위치가 모두 불일치 할 경우 NOTHING 을 반환한다.")
    void nothing() {
        Ball playerBall = new Ball(3, 1);
        BallState result = answerBall.compare(playerBall);
        assertThat(result).isEqualTo(BallState.NOTHING);
    }

    @Test
    @DisplayName("볼의 숫자는 1 ~ 9까지의 숫자만 가능하다.")
    void validate1() {
        assertThat(new Ball(5, 1)).isNotNull();
        assertThat(new Ball(9, 1)).isNotNull();

        assertThatThrownBy(() -> new Ball(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(10, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼의 위치는 1 ~ 3까지의 숫자만 가능하다.")
    void validate2() {
        assertThat(new Ball(5, 1)).isNotNull();
        assertThat(new Ball(5, 3)).isNotNull();

        assertThatThrownBy(() -> new Ball(1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(1, 4)).isInstanceOf(IllegalArgumentException.class);
    }
}
