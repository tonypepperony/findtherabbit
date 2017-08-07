import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Rabbit extends Animals{
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
        System.out.println("Вы видите Зайца!");

        while (true){
            try {
                System.out.println("Ваши действия: \n>1.Стреляем! \n>2.Бросить морковку \n>3.Уйти");
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.println(">> Bang!");
                    shoot(getChance());
                } else if (inputNumber == 2){
                    giveCarrot();
                } else if (inputNumber == 3){
                    System.out.println("Куда это уйти собрался? Мы тут на зайца охотиться пришли!");
                }
            } catch (NumberFormatException e){
                System.out.println("Выберите действие: 1-3");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void shoot(int chance) throws InterruptedException {
        if (random.nextInt(100) < getChance()){
            System.out.println(">> Точное попадание! +50 очков");
            System.out.println("Вы убиваете зайца!");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Игра закончена.");
            Main.setPoints(Main.getPoints()+50);
            TimeUnit.SECONDS.sleep(3);
            win();
        } else {
            System.out.println(">> Заяц отпрыгнул, вы не попали!");
            Main.setPatron(Main.getPatron()-1);
            StopGame.checkPatronOut();
        }
    }

    private void win(){
        System.out.println("report");
        System.exit(0);
    }

    private void giveCarrot() throws InterruptedException {
        if (Main.getCarrot() > 0){
            Main.setCarrot(Main.getCarrot()-1);
            setChance(getChance()+10);
            System.out.println(">> Вы кидаете зайцу морковку, заяц отвлекается.");
            System.out.println("[-1 морковка]");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("[+10% шанс попадания в зайца]");
        } else {
            System.out.println(">> У вас нет морковок.");
        }
    }

}
