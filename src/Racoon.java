import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Racoon extends Animals {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Random random = new Random();

    @Override
    void action() {
        System.out.println("Вы встретили енота!\nВаши действия: \n>1.Попробовать погладить (+1мин. к игровому времени) \n>2.Угостить печенькой  \n>3.Уйти");

        while (true){
            try {
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.println(">> Вы пытаетесь погладить енота");
                    TimeUnit.SECONDS.sleep(1);
                    caress();
                    System.out.println("Енот убегает");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nИдем дальше");
                    break;
                } else if (inputNumber == 2){
                    giveCookie();
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

    private void caress(){
        if (random.nextInt(2) == 1){
            AddTime.setAddtime(AddTime.getAddtime() + 60000);
            System.out.println("Енот поглажен, вы получаете +1мин. к игровому времени");
        } else {
            System.out.println("Енот оказывается злой и кусает вас!");
        }
    }

    private void giveCookie() throws InterruptedException {
        if (Main.getCookies() > 0){
            System.out.println("Достаем печеньку, даем её еноту");
            System.out.println("-1 cookies");
            Main.setCookies(Main.getCookies()-1);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("*Енот ест печенье* ");
            for(int i = 0; i < (5 + random.nextInt(8)); i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
            int rr = rabbitRange();
            System.out.println("\n>> Енот: заяц в районе " + rr + "-" + (rr+10) + "!");
        } else {
            System.out.println("У вас нет печенек!");
        }
    }

    private int rabbitRange(){
        if (Main.getRabbitNumber() <= 10){
            return 0;
        } else if (Main.getRabbitNumber() >= 90){
            return 90;
        } else {
            return (Main.getRabbitNumber()-random.nextInt(11));
        }
    }
}
