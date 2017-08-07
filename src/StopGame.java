public class StopGame {

    static void checkPatronOut() {
        if (Main.getPatron() > 0) {
            System.out.println("[Осталось зарядов:" + Main.getPatron() + "]");
        } else {
            System.out.println("Патрон больше нет. Игра закончена!");
            System.out.println("Ваш счет:" + Main.getPoints());
            System.exit(0);
        }
    }

    static void checkHealthOut() {
        if (Main.getHealth() > 0) {
            System.out.println("[Осталось сил:" + Main.getPatron() + "]");
        } else {
            System.out.println("Сил больше нет. Медведь вас убивает и съедает. Игра закончена!");
            System.out.println("Ваш счет:" + Main.getPoints());
            System.exit(0);
        }
    }
}
