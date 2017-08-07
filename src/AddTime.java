import java.util.Timer;
import java.util.TimerTask;

class AddTime extends TimerTask {
    private static int addtime = 0;

    public static int getAddtime() {
        return addtime;
    }

    public static void setAddtime(int addtime) {
        AddTime.addtime = addtime;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new StopTimeOut(), getAddtime());
    }
}
