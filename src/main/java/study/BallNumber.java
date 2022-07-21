package study;

import java.util.Objects;
import java.util.Random;

public class BallNumber {

    public static final int MIN_BALL_NO = 1;
    public static final int MAX_BALL_NO = 9;
    private final int no;

    public BallNumber(int no) {
        if (no < MIN_BALL_NO || no > MAX_BALL_NO) {
            throw new IllegalArgumentException("볼 숫자는 1 ~ 9까지만 사용가능합니다.");
        }
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }

    public static BallNumber createRandom() {
        int randomNo = getRandomNo();
        return new BallNumber(randomNo);
    }

    private static int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BALL_NO) + MIN_BALL_NO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
