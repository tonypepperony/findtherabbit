import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Bear extends Animals {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Random random = new Random();
    private int chance = 20;

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    @Override
    void action() {
        System.out.println("Господи! Вы встретили МЕДВЕДЯ!");
        System.out.println(">> От страха вы роняете ружье.");
        while (true){
            try {
                System.out.println("\nВаши действия: \n>1.Попробовать убежать \n>2.Съесть ягоду \n>3.Кинуть шишкой \n>4.Уйти");
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.print(">> Убегаем от медведя");
                    for(int i = 0; i < 4; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                    }
                    if (run(getChance())) break;
                } else if (inputNumber == 2){
                    eatBerries();
                } else if (inputNumber == 3){
                    throwCone();
                } else if (inputNumber == 4){
                    System.out.println("Вы серьезно? Собрались просто так взять и уйти от медведя?");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Медведь хватает вас, отрывает вам голову и съедает!");
                    System.out.println("Игра закончена!");
                    System.out.println("Ваш счет:" + Main.getPoints());
                    System.exit(0);
                }
            } catch (NumberFormatException e){
                System.out.println("Выберите действие: 1-3");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean run(int chance) throws InterruptedException {

        if (random.nextInt(100) < getChance()){
            System.out.println("\n>> Вам удалось убежать от медведя, и даже успели захватить свое ружьё.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("На этот раз вам повезло, но лучше его больше не встречать.\n");
            TimeUnit.SECONDS.sleep(2);
            return true;
        } else {
            System.out.println("\n>> Медведь вас догоняет!");
            Main.setHealth(Main.getHealth()-1);
            StopGame.checkHealthOut();
            return false;
        }
    }

    private void eatBerries(){
        if (Main.getBerries() > 0){
            Main.setBerries(Main.getBerries()-1);
            System.out.println(">> Съедаем ягоду [-1 ягода]");
            System.out.println("+1 к силам для побега");
            Main.setHealth(Main.getHealth()+1);
        } else {
            System.out.println("[У вас нет ягод]");
        }
    }

    private void throwCone() throws InterruptedException {
        if (Main.getPinecone()>0){
            System.out.println(">> Кидаем шишкой в медведя [-1 шишка]");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(">> Попадаем медведю в голову [+10% к шансу убежать]");
            TimeUnit.SECONDS.sleep(1);
            Main.setPinecone(Main.getPinecone()-1);
            setChance(getChance()+10);
        } else {
            System.out.println("[У вас нет шишек]");
        }
    }
}
