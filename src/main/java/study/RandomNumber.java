package study;

import java.util.HashSet;
import java.util.Set;

public class RandomNumber {

    public static Set<BallNumber> create(final int creatSize) {
        Set<BallNumber> ballNumbers = new HashSet<>();
        while(ballNumbers.size() < creatSize) {
            ballNumbers.add(BallNumber.createRandom());
        }
        return ballNumbers;
    }
}
