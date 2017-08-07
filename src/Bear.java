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
        System.out.println("Вы встретили медведя!");

        while (true){
            try {
                System.out.println("Ваши действия: \n>1.Попробовать убежать \n>2.Съесть ягоду \n>3.Кинуть шишкой \n>4.Уйти");
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.print("Убегаем от медведя");
                    for(int i = 0; i < (5 + random.nextInt(6)); i++) {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                    }
                    run(getChance());
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

    private void run(int chance) throws InterruptedException {
        if (random.nextInt(100) < getChance()){
            System.out.println(">> Вы оторвались от медведя.");
            System.out.println("На этот раз вам повезло, лучше его больше не встречать!");
            TimeUnit.SECONDS.sleep(2);
        } else {
            System.out.println(">> Медведь вас догоняет!");
            Main.setHealth(Main.getHealth()-1);
            StopGame.checkHealthOut();
        }
    }

    private void eatBerries(){
        if (Main.getBerries() > 0){
            Main.setBerries(Main.getBerries()-1);
            System.out.println(">> Вы съедаете ягоду");
            System.out.println("Силы для побега +1");
            System.out.println("[-1 ягода]");
        }
    }

    private void throwCone(){
        //throw
    }
}
