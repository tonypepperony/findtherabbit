import java.io.*;
import java.util.*;

public class Main {

    private static int points = 0;
    private static int health = 3;
    private static int patron = 10;
    private static int cookies = 0;
    private static int carrot = 0;
    private static int pinecone = 0;
    private static int berries = 0;
    private static int rabbitNumber;
    private static int bearNumber;


    public static void main(String[] args) throws IOException {

        int inputNumber;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String instruction = "                 [Правила игры]\n\n                    Цель игры\n" +
                "Найти и пристрелить зайца. Заяц во время стрельбы будет \nпрыгать и уворачиваться,шанс попасть 20%." +
                "Шансы попадания \nможно увеличить подкармливая его морковкой (+10% за одну \nморковку). " +
                "Встретив зайца,стреляем до последнего,сколько \nхватит патронов, их кстати лучше поберечь для зайца и " +
                "\nпопросту не растрачивать во время игры, т.к. всего 10 шт.\n\n" +
                "                    Время игры\n" +
                "Основное время игры 5 минут. По ходу игры можно будет \nзарабатывать доп. время погладив енотов (+1 минута за \nодного енота). " +
                "При взаимодействии с разными персонажами \nбудет затрачиваться различное кол-во времени. Берегите \nвремя, это ваш ценный ресурс. \n\n" +
                "                  Игровой процесс\n" +
                "В начале игры генерируется лес, который состоит из 100 \nлокаций. В каждый ваш ход вы выбираете локацию (от 1 до 100),\n" +
                "где вас будет ждать персонаж, или найдете там полезный итем. \nИщем зайца, собираем полезные итемы (которые, в дальнейшем, могут \nпригодиться для выживания), " +
                "стараемся не встретить медведя.\n\n" +
                "                    Персонажи\n" +
                "Птица. " +
                "" +
                "Дополнительное время можно зарабатывать ТОЛЬКО во время основного времени, гладить енотов после старта доп. времени бессмысленно." +
                "\n Для начала игры введите 1, для выхода из игры введите 3 \n";

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
                    System.out.println("Good bye!");
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
        timer.schedule(new AddTime(), 300000);

        System.out.println(" Игра началась!\nИдем по лесу [Выберите точку 1-100]");

        for (Animals frst : forest){
            System.out.println(frst.getKind());
        }

        //System.out.println("Rabbit : " + rabbitNumber);
        //System.out.println("Bear : " + bearNumber);


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
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Rabbit")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Carrot")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Pinecone")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    } else if (forest.get(inputNumber).getKind().equals("Berries")) {
                        forest.get(inputNumber).action();
                        System.out.println("[Выберите точку 1-100]");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("введите целое число \n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static ArrayList<Animals> createForest(){
        ArrayList<Animals> forest = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            Bird bird = new Bird();
            bird.setKind("Bird");
            forest.add(bird);
        }

        for (int i = 0; i < 20; i++) {
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

        for (int i = 0; i < 5; i++) {
            Carrot carrot = new Carrot();
            carrot.setKind("Carrot");
            forest.add(carrot);
        }

        for (int i = 0; i < 5; i++) {
            Pinecone pinecone = new Pinecone();
            pinecone.setKind("Pinecone");
            forest.add(pinecone);
        }

        for (int i = 0; i < 13; i++) {
            Berries berries = new Berries();
            berries.setKind("Berries");
            forest.add(berries);
        }

        Bear bear = new Bear();
        bear.setKind("Bear");
        forest.add(bear);

        Rabbit rabbit = new Rabbit();
        rabbit.setKind("Rabbit");
        forest.add(rabbit);

        return forest;

    }

    private static int checkRabbit(ArrayList<Animals> forest){
        int n =0;
        for (int i = 0; i < forest.size(); i++) {
            if (forest.get(i).getKind().equals("Rabbit")){
                n = i;
            }
        }
        return n + 1;
    }

    private static int checkBear(ArrayList<Animals> forest){
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

    public static int getCookies() {
        return cookies;
    }

    public static void setCookies(int cookies) {
        Main.cookies = cookies;
    }

    public static int getCarrot() {
        return carrot;
    }

    public static void setCarrot(int carrot) {
        Main.carrot = carrot;
    }

    public static int getPinecone() {
        return pinecone;
    }

    public static void setPinecone(int pinecone) {
        Main.pinecone = pinecone;
    }

    public static int getBerries() {
        return berries;
    }

    public static void setBerries(int berries) {
        Main.berries = berries;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Main.health = health;
    }
}
