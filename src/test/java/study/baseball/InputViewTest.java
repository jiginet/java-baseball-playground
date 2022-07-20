package study.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @ParameterizedTest
    @CsvSource({"123,true", "1234,false", "12,false", "aaa,false", "12a,false"})
    void isValidNumberTest(String input, boolean expected) {
        // given
        InputView inputView = new InputView();

        // when
        boolean actual = inputView.isValidNumber(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,false", "a,false", "3a,false"})
    void isValidMenu(String input, boolean expected) {
        // given
        InputView inputView = new InputView();

        // when
        boolean actual = inputView.isValidMenu(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}