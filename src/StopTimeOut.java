import java.util.TimerTask;

public class StopTimeOut extends TimerTask {
    private static boolean stopGame;

    public static boolean isStopGame() {
        return stopGame;
    }

    @Override
    public void run() {
        System.out.println("Время вышло. Игра закончена!");
        Main.countPoints();
        Main.printReport();
        System.exit(0);
        stopGame = true;
    }

}
