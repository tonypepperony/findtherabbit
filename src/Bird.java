import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Bird extends Animals {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Random random = new Random();

    @Override
    void animalAction() {
        System.out.println("Вы встретили птицу!\nВаши действия: \n>1.Попробовать поймать [шанс поймать: 50%|затраты времени:5-10сек.|+2очка] \n>2.Пристрелить [-1патрон|+2очка]  \n>3.Уйти");

        while (true){
            try {
                int inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    System.out.println("Вы побежали за птицей");
                    catchBird();
                    System.out.println("Идем дальше");
                    break;
                } else if (inputNumber == 2){
                    System.out.println("Bang! +2 очка");
                    Main.setPoints(Main.getPoints()+2);
                    Main.setPatron(Main.getPatron()-1);
                    StopGame.checkPatronOut();
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

    private void catchBird() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5 + random.nextInt(6)); //ждем 5-10секунд

        if (random.nextInt(2) == 1){
            System.out.println("Вы поймали птицу! +2 очка");
            Main.setPoints(Main.getPoints() + 2);
        } else {
            System.out.println("Птицу поймать не удалось :(");
        }
    }
}
