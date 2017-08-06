import java.util.concurrent.TimeUnit;

class Cookie extends Animals{
    @Override
    void action() throws InterruptedException {
        System.out.println("Вы нашли печенье!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+1 cookies\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Идем дальше");
        Main.setCookies(Main.getCookies()+1);
    }
}
