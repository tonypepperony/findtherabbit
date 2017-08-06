public class StopGame {

    static void checkPatronOut() {
        if (Main.getPatron() > 0) {
            System.out.println("Осталось зарядов: " + Main.getPatron());
        } else {
            System.out.println("Патрон больше нет. Игра закончена!");
            System.out.println("Ваш счет:" + Main.getPoints());
            System.exit(0);
        }
    }
}
