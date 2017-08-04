package timers;

import java.util.TimerTask;

public class StopTheGame extends TimerTask {
    static boolean stopGame;

    public static boolean isStopGame() {
        return stopGame;
    }

    @Override
    public void run() {
        System.out.println("Время вышло, вы проиграли.");
        System.exit(0);
        stopGame = true;
    }
}
