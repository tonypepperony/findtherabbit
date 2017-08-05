import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bird extends Animals {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int inputNumber;

    @Override
    void animalAction() {
        System.out.println("Вы встретили птицу!\nВаши действия: \n>1.Попробовать поймать (-5сек. +2очка) \n>2.Пристрелить (+2очка)  \n>3.Уйти");

        while (true){
            try {
                inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    break;
                } else if (inputNumber == 2){
                    System.out.println("Bang! +2 очка");
                    Main.setPoints(Main.getPoints()+2);
                    Main.setPatron(Main.getPatron()-1);
                    StopGame.checkPatronOut();
                    break;
                } else if (inputNumber == 3){
                    System.out.println("Вы ушли.");
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Выберите действие: 1-3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
