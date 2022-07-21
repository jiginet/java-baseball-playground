package study;

public class Ball {

    public static final int MIN_BALL_NO = 1;
    public static final int MAX_BALL_NO = 9;
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;
    private final int ballNo;
    private final int position;

    public Ball(int ballNo, int position) {
        if (ballNo < MIN_BALL_NO || ballNo > MAX_BALL_NO) {
            throw new IllegalArgumentException("볼 넘버는 1 ~ 9까지의 숫자만 가능합니다.");
        }
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("볼 포지션은 1 ~ 3까지의 숫자만 가능합니다.");
        }
        this.ballNo = ballNo;
        this.position = position;
    }

    public BallState compare(Ball playerBall) {
        if (this.equals(playerBall)) {
            return BallState.STRIKE;
        }
        if (playerBall.isSame(ballNo)) {
            return BallState.BALL;
        }
        return BallState.NOTHING;
    }

    private boolean isSame(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return ballNo == ball.ballNo &&
            position == ball.position;
    }
}
