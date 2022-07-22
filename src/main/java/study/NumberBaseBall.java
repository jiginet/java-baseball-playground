package study;

import java.util.List;

public class NumberBaseBall {

    public static final int GAME_CONTINUE = 1;
    private final InputView inputNumber = new InputView(3, "숫자를 입력해 주세요 :");
    private final InputView inputMenu = new InputView(1, "계속은 1번, 중단은 그 외 :");

    public void play() {
        Balls answerBalls = Balls.createRandom();
        PlayResult playResult;
        do {
            List<Integer> playerBallNos = inputNumber.read();
            playResult = answerBalls.play(playerBallNos);
            ResultView.show(playResult);
        }
        while (!playResult.isGameEnd());
    }

    public boolean isContinue() {
        return inputMenu.read().get(0) == GAME_CONTINUE;
    }

    public static void main(String[] args) {
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        do {
            numberBaseBall.play();
        } while (numberBaseBall.isContinue());
    }
}
