package study.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class NumberBaseballTest {

    private NumberBaseball numberBaseball;

    @BeforeEach
    void setUp() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        numberBaseball = new NumberBaseball();
    }

    @Test
    void random() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int actual = random.nextInt(9) + 1;
            System.out.println("actual = " + actual);
            assertThat(actual).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("숨겨진 숫자가 초기화될 때마다 달라진다.")
    void initialHiddenNumbers() {
        // given
        int[] hiddenNumbers1 = numberBaseball.getHiddenNumbers().clone();

        // when
        numberBaseball.initialHiddenNumbers();
        int[] hiddenNumbers2 = numberBaseball.getHiddenNumbers().clone();

        // then
        assertThat(hiddenNumbers1).isNotEqualTo(hiddenNumbers2);
    }

    @Test
    void getUniqueNumber() {
        // given
        final int[] hiddenNumbers = numberBaseball.getHiddenNumbers();

        // when-then
        for (int i = 0; i < 100; i++) {
            int uniqueNumber = numberBaseball.getUniqueNumber();
            assertThat(uniqueNumber)
                .isNotEqualTo(hiddenNumbers[0])
                .isNotEqualTo(hiddenNumbers[1])
                .isNotEqualTo(hiddenNumbers[2]);
        }
    }

    @Test
    void isExistsNumber() {
        // given
        final int[] hiddenNumbers = numberBaseball.getHiddenNumbers();

        // when
        boolean actual1 = numberBaseball.isExistsNumber(hiddenNumbers[0]);
        boolean actual2 = numberBaseball.isExistsNumber(hiddenNumbers[1]);
        boolean actual3 = numberBaseball.isExistsNumber(hiddenNumbers[2]);
        boolean actual4 = numberBaseball.isExistsNumber(0);

        // then
        assertThat(actual1).isTrue();
        assertThat(actual2).isTrue();
        assertThat(actual3).isTrue();
        assertThat(actual4).isFalse();
    }

    @Test
    void getRandomNumber() {
        for (int i = 0; i < 100; i++) {
            int actual = numberBaseball.getRandomNumber();
            assertThat(actual).isBetween(1, 9);
        }
    }

    @Test
    void isContinue() {
        // given
        GameResult fourBall = new GameResult(0, 0);
        GameResult oneStrike = new GameResult(1, 0);
        GameResult threeStrike = new GameResult(3, 0);

        // when
        boolean isTrue1 = numberBaseball.isContinue(fourBall);
        boolean isTrue2 = numberBaseball.isContinue(oneStrike);
        boolean isTrue3 = numberBaseball.isContinue(threeStrike);

        // then
        assertThat(isTrue1).isTrue();
        assertThat(isTrue2).isTrue();
        assertThat(isTrue3).isTrue();
    }

    @Test
    void calculate() {
        // given
        final String input = "123";

        // when
        GameResult result = numberBaseball.calculate(input);

        // then
        assertThat(result).isNotNull();

    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void countStrike(String input) {
        // given
        // when
        int result = numberBaseball.countStrike(input);

        // then
        assertThat(result).isBetween(0, 3);
    }

    @ParameterizedTest
    @CsvSource({"1,0", "2,0", "3,0", "1,1", "1,2", "3,2"})
    void isStrike(char input, int position) {
        // given
        // when
        int result = numberBaseball.isStrike(input, position);

        // then
        assertThat(result).isIn(0, 1);

    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void countBall(String input) {
        // given
        // when
        int result = numberBaseball.countBall(input);

        // then
        assertThat(result).isBetween(0, 3);
    }

    @ParameterizedTest
    @CsvSource({"1,0", "2,0", "3,0", "1,1", "1,2", "3,2"})
    void isBall(char input, int position) {
        // given
        // when
        int result = numberBaseball.isStrike(input, position);

        // then
        assertThat(result).isIn(0, 1);
    }
}