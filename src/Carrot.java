import java.util.concurrent.TimeUnit;

public class Carrot extends Animals {
    @Override
    void action() throws InterruptedException {
        System.out.println("Вы нашли морковку!");
        System.out.println("Это поможет вам в охоте на зайца!");
        System.out.println("+1 carrot\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Идем дальше");
        Main.setCarrot(Main.getCarrot()+1);
    }
}
