package study;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int REQUIRED_BALL_SIZE = 3;
    private final List<Ball> balls;
    private int strikeCount;
    private int ballCount;

    public Balls(List<Integer> ballNos) {
        validate(ballNos);
        this.balls = mapTo(ballNos);
    }

    private List<Ball> mapTo(final List<Integer> ballNos) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < REQUIRED_BALL_SIZE; i++) {
            balls.add(new Ball(ballNos.get(i), i + 1));
        }
        return balls;
    }

    private void validate(final List<Integer> ballNos) {
        if (ballNos == null) {
            throw new IllegalArgumentException("ballNos 는 필수 입력값입니다.");
        }
        if (ballNos.size() != REQUIRED_BALL_SIZE) {
            throw new IllegalArgumentException("리스트는 " + REQUIRED_BALL_SIZE + "개만 허용합니다.");
        }
        if (!hasOnlyUniqueNumbers(ballNos)) {
            throw new IllegalArgumentException("각각의 수는 서로 중복되지 않아야 합니다.");
        }
    }

    private boolean hasOnlyUniqueNumbers(final List<Integer> ballNos) {
        return ballNos.size() == ballNos.stream()
            .distinct()
            .count();
    }

    public BallState compare(final Ball playerBall) {
        return balls.stream()
            .map(ball -> ball.compare(playerBall))
            .filter(BallState::isNotNothing)
            .findFirst()
            .orElse(BallState.NOTHING);
    }

    public PlayResult play(final List<Integer> playerBallNos) {
        Balls playerBalls = new Balls(playerBallNos);

        PlayResult result = new PlayResult();

        for (Ball answerBall : balls) {
            BallState state = playerBalls.compare(answerBall);
            result.report(state);
        }
        return result;
    }

    private void resultReport(BallState ballState) {
        if (ballState.isStrike()) {
            strikeCount++;
        }
        if (ballState.isBall()) {
            ballCount++;
        }
    }

}
