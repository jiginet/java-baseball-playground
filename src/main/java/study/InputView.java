package study;

import static study.Balls.REQUIRED_BALL_SIZE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> read() {
        String input = readNumber();
        return Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private String readNumber() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print(REQUIRED_BALL_SIZE + "자리 숫자를 입력해 주세요 : ");
            input = scanner.nextLine();
        } while (!isValidNumber(input));

        return input;
    }

    private boolean isValidNumber(final String input) {
        if (input.length() != REQUIRED_BALL_SIZE) {
            return false;
        }
        if (!input.matches("^[1-9]{" + REQUIRED_BALL_SIZE + "}$")) {
            return false;
        }
        return true;
    }
}
