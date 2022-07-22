package study;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final int inputSize;
    private final String message;

    public InputView(int inputSize, String message) {
        this.inputSize = inputSize;
        this.message = message;
    }

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
            System.out.print(message);
            input = scanner.nextLine();
        } while (!isValidNumber(input));

        return input;
    }

    private boolean isValidNumber(final String input) {
        if (input.length() != inputSize) {
            return false;
        }
        if (!input.matches("^[1-9]{" + inputSize + "}$")) {
            return false;
        }
        return true;
    }
}
