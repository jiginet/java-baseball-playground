package study;

public class ResultView {

    public static void show(PlayResult playResult) {
        if (!playResult.hasStrike() && !playResult.hasBall()) {
            System.out.println("없음");
        }
        StringBuilder message = new StringBuilder();
        if (playResult.hasStrike()) {
            message.append(playResult.getStrikeCount());
            message.append("스트라이크");
        }
        if (playResult.hasStrike() && playResult.hasBall()) {
            message.append(", ");
        }
        if (playResult.hasBall()) {
            message.append(playResult.getBallCount());
            message.append("볼");
        }
        System.out.println(message.toString());
    }

}
