package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    Balls answerBalls;

    @BeforeEach
    void setUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3:3 비교 : 0 스트라이크 1 볼")
    void play1() {
        // when
        PlayResult result = answerBalls.play(Arrays.asList(3, 4, 5));
        // then
        assertThat(result).extracting("strikeCount", "ballCount").containsExactly(0, 1);
    }

    @Test
    @DisplayName("3:3 비교 : 1 스트라이크 0 볼")
    void play2() {
        // when
        PlayResult result = answerBalls.play(Arrays.asList(1, 4, 5));
        // then
        assertThat(result).extracting("strikeCount", "ballCount").containsExactly(1, 0);
    }

    @Test
    @DisplayName("3:3 비교 : 1 스트라이크 1 볼")
    void play3() {
        // when
        PlayResult result = answerBalls.play(Arrays.asList(1, 3, 4));

        // then
        assertThat(result).extracting("strikeCount", "ballCount").containsExactly(1, 1);
    }

    @Test
    @DisplayName("3:3 비교 : 0 스트라이크 0 볼")
    void play4() {
        // when
        PlayResult result = answerBalls.play(Arrays.asList(4, 5, 6));

        // then
        assertThat(result).extracting("strikeCount", "ballCount").containsExactly(0, 0);
    }

    @Test
    @DisplayName("3:3 비교 : 3 스트라이크 0 볼")
    void play5() {
        // when
        PlayResult result = answerBalls.play(Arrays.asList(1, 2, 3));

        // then
        assertThat(result).extracting("strikeCount", "ballCount").containsExactly(3, 0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("3:1 비교 : 숫자와 위치가 모두 일치 할 경우 STRIKE 를 반환한다.")
    void strike() {
        // when
        BallState result1 = answerBalls.compare(new Ball(1, 1));
        BallState result2 = answerBalls.compare(new Ball(2, 2));
        BallState result3 = answerBalls.compare(new Ball(3, 3));

        // then
        assertThat(result1).isEqualTo(BallState.STRIKE);
        assertThat(result2).isEqualTo(BallState.STRIKE);
        assertThat(result3).isEqualTo(BallState.STRIKE);
    }

    @Test
    @DisplayName("3:1 비교 : 숫자는 일치하고, 위치가 불일치 할 경우 BALL 을 반환한다.")
    void ball() {
        // when
        BallState result1 = answerBalls.compare(new Ball(1, 2));
        BallState result2 = answerBalls.compare(new Ball(2, 3));
        BallState result3 = answerBalls.compare(new Ball(3, 1));

        // then
        assertThat(result1).isEqualTo(BallState.BALL);
        assertThat(result2).isEqualTo(BallState.BALL);
        assertThat(result3).isEqualTo(BallState.BALL);
    }

    @Test
    @DisplayName("3:1 비교 : 숫자와 위치가 모두 불일치 할 경우 NOTHING 을 반환한다.")
    void nothing() {
        // when
        BallState result1 = answerBalls.compare(new Ball(4, 1));
        BallState result2 = answerBalls.compare(new Ball(5, 2));
        BallState result3 = answerBalls.compare(new Ball(6, 3));

        // then
        assertThat(result1).isEqualTo(BallState.NOTHING);
        assertThat(result2).isEqualTo(BallState.NOTHING);
        assertThat(result3).isEqualTo(BallState.NOTHING);
    }

    @Test
    @DisplayName("각각의 볼들은 중복되지 않은 수들로 이뤄져 있다.")
    void validate1() {
        assertThat(new Balls(Arrays.asList(1, 2, 3))).isNotNull();
        assertThat(new Balls(Arrays.asList(4, 5, 6))).isNotNull();

        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 1, 2))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3개의 볼로 이뤄져 있다.")
    void validate2() {
        assertThat(new Balls(Arrays.asList(1, 2, 3))).isNotNull();

        assertThatThrownBy(() -> new Balls(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 2, 3, 4))).isInstanceOf(IllegalArgumentException.class);
    }
}
