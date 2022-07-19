package study.baseball;

import java.util.Random;

public class NumberBaseball {

    private int[] hiddenNumbers = new int[3];
    private final Random random = new Random();

    public NumberBaseball() {
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
        System.out.println("randomNumber = " + randomNumber);
        return randomNumber;
    }

    public boolean isExistsNumber(int number) {
        if (hiddenNumbers[0] == number || hiddenNumbers[1] == number
            || hiddenNumbers[2] == number) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public int[] getHiddenNumbers() {
        return hiddenNumbers;
    }
}
