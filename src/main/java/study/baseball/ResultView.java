package study.baseball;

public class ResultView {

    public void display(GameResult result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.println("4볼");
        }
        StringBuilder message = new StringBuilder();
        if (result.getStrike() > 0) {
            message.append(result.getStrike()).append("스트라이크").append(" ");
        }
        if (result.getBall() > 0) {
            message.append(result.getBall()).append("볼");
        }
        System.out.println(message);
    }


}
