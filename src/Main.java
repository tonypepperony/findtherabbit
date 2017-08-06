import java.io.*;
import java.util.*;

public class Main {

    static int points = 0;
    private static int patron = 10;
    static int rabbitNumber;
    static int bearNumber;


    public static void main(String[] args) throws IOException {

        int inputNumber;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String instruction = " [Правила игры]\nИгра длится 5 минут\n У вас есть 10 патрон\nИтд дописать\n Для начала игры введите 1, для выхода из игры введите 3 \n";

        //Intro
        System.out.println(" [Охота на зайца] \n >1.Начать игру \n >2.Правила \n >3.Выход" );
        while (true){
            try {
                inputNumber = Integer.parseInt(reader.readLine());
                if (inputNumber == 1){
                    break;
                } else if (inputNumber == 2){
                    System.out.println(instruction);
                } else if (inputNumber == 3){
                    System.out.println("До свидания!");
                    System.exit(0);
                } else {
                    System.out.println("Выберите действие: 1-3");
                }
            } catch (NumberFormatException e){
                System.out.println("Выберите действие: 1-3");
            }
        }

        //Start
        ArrayList<Animals> forest = createForest();
        Collections.shuffle(forest);
        rabbitNumber = checkRabbit(forest);
        bearNumber = checkBear(forest);

        Timer timer = new Timer();
        timer.schedule(new StopTimeOut(), 300000);

        System.out.println(" Игра началась!\nИдем по лесу [Выберите точку 1-100]");

//        for (Animals frst : forest){
//            System.out.println(frst.getKind());
//        }


        while (!StopTimeOut.isStopGame()) {

            try {
                inputNumber = Integer.parseInt(reader.readLine());

                if ((inputNumber < 1)||(inputNumber > 100)){
                    System.out.println("выберите число от 1 до 100");
                } else {
                    inputNumber--;
                    if (forest.get(inputNumber).getKind().equals("Bird")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Fox")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Racoon")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Cookie")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Bear")) {
                        forest.get(inputNumber).action();
                    } else if (forest.get(inputNumber).getKind().equals("Rabbit")) {
                        forest.get(inputNumber).action();
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("введите целое число \n");
            }
        }

    }

    private static ArrayList<Animals> createForest(){
        ArrayList<Animals> forest = new ArrayList<>();

        for (int i = 0; i < 53; i++) {
            Bird bird = new Bird();
            bird.setKind("Bird");
            forest.add(bird);
        }

        for (int i = 0; i < 30; i++) {
            Fox fox = new Fox();
            fox.setKind("Fox");
            forest.add(fox);
        }

        for (int i = 0; i < 10; i++) {
            Racoon racoon = new Racoon();
            racoon.setKind("Racoon");
            forest.add(racoon);
        }

        for (int i = 0; i < 5; i++) {
            Cookie cookie = new Cookie();
            cookie.setKind("Cookie");
            forest.add(cookie);
        }

        Bear bear = new Bear();
        bear.setKind("Bear");
        forest.add(bear);

        Rabbit rabbit = new Rabbit();
        rabbit.setKind("Rabbit");
        forest.add(rabbit);

        return forest;

    }

    static int checkRabbit(ArrayList<Animals> forest){
        int n =0;
        for (int i = 0; i < forest.size(); i++) {
            if (forest.get(i).getKind().equals("Rabbit")){
                n = i;
            }
        }
        return n + 1;
    }

    static int checkBear(ArrayList<Animals> forest){
        int n =0;
        for (int i = 0; i < forest.size(); i++) {
            if (forest.get(i).getKind().equals("Bear")){
                n = i;
            }
        }
        return n + 1;
    }

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        Main.points = points;
    }

    public static int getPatron() {
        return patron;
    }

    public static void setPatron(int patron) {
        Main.patron = patron;
    }

    public static int getRabbitNumber() {
        return rabbitNumber;
    }

    public static int getBearNumber() {
        return bearNumber;
    }
}
