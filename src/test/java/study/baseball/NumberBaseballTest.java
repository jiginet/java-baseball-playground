package study.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class NumberBaseballTest {

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
        NumberBaseball numberBaseball = new NumberBaseball();
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
        NumberBaseball numberBaseball = new NumberBaseball();
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
        NumberBaseball numberBaseball = new NumberBaseball();
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
        // given
        NumberBaseball numberBaseball = new NumberBaseball();

        // when-then
        for (int i = 0; i < 100; i++) {
            int actual = numberBaseball.getRandomNumber();
            assertThat(actual).isBetween(1, 9);
        }
    }
}