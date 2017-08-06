import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fox extends Animals {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Random random = new Random();

    @Override
    void action() {
        System.out.println("Вы встретили лису!\nВаши действия: \n>1.Спросить где заяц \n>2.Пристрелить (5 очков)  \n>3.Уйти");

        while (true){
            try {
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.println(">>  Спрашиваем лису");
                    clue();
                    System.out.println("\nИдем дальше");
                    break;
                } else if (inputNumber == 2){
                    System.out.println("Bang! +5 очков");
                    Main.setPoints(Main.getPoints()+5);
                    Main.setPatron(Main.getPatron()-1);
                    StopGame.checkPatronOut();
                    System.out.println("\nИдем дальше");
                    break;
                } else if (inputNumber == 3){
                    System.out.println("Уходим");
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Выберите действие: 1-3");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        private void clue() throws InterruptedException {

            System.out.println("Лиса: ну я его где-то видела");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("Лиса: дай-ка вспомнить");
            for(int i = 0; i < (5 + random.nextInt(11)); i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }

            if (random.nextInt(2) == 1){
                int rr = rabbitRange();
                System.out.println("\n>> Лиса: Ах да! Заяц был в районе " + rr + "-" + (rr+30) + "  =^.^=");
            } else {
                int br = bearRange();
                System.out.println("\n>> Лиса: Ах да! Заяц был в районе " + br + "-" + (br+30) + "  =^.^=");
            }

        }

        private int rabbitRange(){
            if (Main.getRabbitNumber() <= 30){
                return 0;
            } else if (Main.getRabbitNumber() >= 70){
                return 70;
            } else {
                return (Main.getRabbitNumber()-random.nextInt(31));
            }
        }

        private int bearRange(){
            if (Main.getBearNumber() <= 30){
                return 0;
            } else if (Main.getBearNumber() >= 70){
                return 70;
            } else {
                return (Main.getBearNumber()-random.nextInt(31));
            }
        }


}
