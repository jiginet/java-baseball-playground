package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersTest {

    public static final int CREAT_SIZE = 3;

    @Test
    @DisplayName("지정한 크기의 볼숫자 목록을 생성해준다.")
    void size() {
        assertThat(RandomNumber.create(CREAT_SIZE)).hasSize(CREAT_SIZE);
    }

    @Test
    @DisplayName("생성된 볼숫자는 모두 다른 숫자들로 구성되어 있다.")
    void allNumberIsUnique() {
        // given
        Set<BallNumber> ballNumbers = RandomNumber.create(3);

        // when
        long uniqueCount = ballNumbers.stream()
            .mapToInt(BallNumber::getNo)
            .distinct().count();

        // then
        assertThat(uniqueCount).isEqualTo(ballNumbers.size());
    }

    @Test
    @DisplayName("1 ~ 9까지 숫자가 랜덤하게 생성된다.")
    void random() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int actual = random.nextInt(9) + 1;
            assertThat(actual).isBetween(1, 9);
        }
    }
}
