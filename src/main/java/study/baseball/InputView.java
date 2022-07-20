package study.baseball;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String readNumber() {
        String input;
        do {
            System.out.print("3자리 숫자를 입력해 주세요 : ");
            input = scanner.nextLine();
        } while (!isValidNumber(input));

        return input;
    }

    public boolean isValidNumber(final String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!input.matches("^[1-9]{3}$")) {
            return false;
        }
        return true;
    }

    public String readMenu() {
        String input;
        do {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
            input = scanner.nextLine();
        } while (!isValidMenu(input));

        return input;
    }

    public boolean isValidMenu(final String input) {
        if (!input.equals("1") && !input.equals("2")) {
            return false;
        }
        return true;
    }

}
