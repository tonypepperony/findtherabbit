import java.util.concurrent.TimeUnit;

public class Berries extends Animals {
    @Override
    void action() throws InterruptedException {
        System.out.println("Вы нашли ягоду!");
        System.out.println("Она придаст вам сил в трудную минуту!");
        System.out.println("[+1 ягода]\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Идем дальше");
        Main.setBerries(Main.getBerries()+1);
    }
}
