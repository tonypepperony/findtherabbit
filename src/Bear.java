
public class Bear extends Animals {
    int health = 3;
    @Override
    void animalAction() {
        System.out.println("Вы встретили медведя!\nВаши действия: \n>1.Попробовать убежать (Шанс 10%) \n>2.Попробовать пристрелить \n>3.Уйти");
    }
}
