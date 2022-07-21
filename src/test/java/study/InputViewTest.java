package study;

import static org.assertj.core.api.Assertions.assertThat;
import static study.Balls.REQUIRED_BALL_SIZE;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    @DisplayName("목록에 중복된 숫자가 없다.")
    void hasOnlyUniqueNumbers() {
        // given
        System.setIn(new ByteArrayInputStream("123\n".getBytes()));
        InputView view = new InputView();

        // when
        List<Integer> numbers = view.read();

        // then
        long uniqueCount = numbers.stream()
            .distinct().count();
        assertThat(uniqueCount).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("사이즈가 " + REQUIRED_BALL_SIZE + "인 숫자목록을 반환한다.")
    void validateSize() {
        // given
        System.setIn(new ByteArrayInputStream("123\n".getBytes()));
        InputView view = new InputView();

        // when
        List<Integer> numbers = view.read();

        // then
        assertThat(numbers).hasSize(3);
    }
}
