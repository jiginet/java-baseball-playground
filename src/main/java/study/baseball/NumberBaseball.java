package study.baseball;

import java.util.Random;

public class NumberBaseball {

    private static final String CONTINUE = "1";
    private final InputView inputView;
    private final ResultView resultView;
    private int[] hiddenNumbers = new int[3];

    public NumberBaseball() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        initialHiddenNumbers();
    }

    public void initialHiddenNumbers() {
        for (int i = 0; i < 3; i++) {
            hiddenNumbers[i] = getUniqueNumber();
        }
    }

    public int getUniqueNumber() {
        int randomNumber = getRandomNumber();
        while (isExistsNumber(randomNumber)) {
            randomNumber = getRandomNumber();
        }
//        System.out.println("randomNumber = " + randomNumber);
        return randomNumber;
    }

    public boolean isExistsNumber(int number) {
        if (hiddenNumbers[0] == number
            || hiddenNumbers[1] == number
            || hiddenNumbers[2] == number) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return new Random().nextInt(9) + 1;
    }

    public int[] getHiddenNumbers() {
        return hiddenNumbers;
    }

    public void run() {
        GameResult gameResult;
        do {
            String inputNumber = inputView.readNumber();
            gameResult = calculate(inputNumber);
            resultView.display(gameResult);
        } while(isContinue(gameResult));
    }

    public boolean isContinue(GameResult gameResult) {
        if (gameResult.isContinue()) {
            return true;
        }
        String inputMenu = inputView.readMenu();
        if (inputMenu.equals(CONTINUE)) {
            initialHiddenNumbers();
            return true;
        }
        return false;
    }

    public GameResult calculate(final String input) {
        final int strike = countStrike(input);
        final int ball = countBall(input);
        return new GameResult(strike, ball);
    }

    public int countStrike(final String input) {
        char[] inputNumbers = input.toCharArray();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += isStrike(inputNumbers[i], i);
        }
        return count;
    }

    public int isStrike(final char inputNumber, final int position) {
        if (Character.getNumericValue(inputNumber) == hiddenNumbers[position]) {
            return 1;
        }
        return 0;
    }

    public int countBall(final String input) {
        char[] inputNumbers = input.toCharArray();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += isBall(inputNumbers[i], i);
        }
        return count;
    }

    public int isBall(final char inputNumber, final int position) {
        final int number = Character.getNumericValue(inputNumber);
        if (number == hiddenNumbers[position]) {
            return 0;
        }
        if (number == hiddenNumbers[0]
            || number == hiddenNumbers[1]
            || number == hiddenNumbers[2]) {
            return 1;
        }
        return 0;
    }
}
