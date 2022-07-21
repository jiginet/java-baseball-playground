package study;

public class PlayResult {

    public static final int END_GAME_STRIKE_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void report(BallState state) {
        if (state.isStrike()) {
            strikeCount++;
        }
        if (state.isBall()) {
            ballCount++;
        }
    }

    public boolean isGameEnd() {
        return strikeCount == END_GAME_STRIKE_COUNT;
    }
}
