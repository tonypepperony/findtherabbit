import java.util.concurrent.TimeUnit;

public class StopGame {

    static void checkPatronOut() {
        if (Main.getPatron() > 0) {
            System.out.println("[Осталось патрон:" + Main.getPatron() + "]");
        } else {
            System.out.println("Патрон больше нет. Игра закончена!");
            Main.countPoints();
            Main.printReport();
            System.exit(0);
        }
    }

    static void checkHealthOut() throws InterruptedException {
        if (Main.getHealth() > 0) {
            System.out.println("[Есть еще силы: " + Main.getHealth() + "]");
        } else {
            System.out.println("Сил больше нет...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(">> Медведь вас догнал, убил и съел.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Игра закончена!");
            Main.countPoints();
            Main.printReport();
            System.exit(0);
        }
    }
}
