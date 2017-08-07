import java.util.concurrent.TimeUnit;

public class Pinecone extends Animals {
    @Override
    void action() throws InterruptedException {
        System.out.println("Вы нашли шишку!");
        System.out.println("Возможно, она спасет вам жизнь!");
        System.out.println("+1 pinecone\n");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Идем дальше");
        Main.setPinecone(Main.getPinecone()+1);
    }
}
