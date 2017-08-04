import java.util.Random;

public class Rabbit extends Animals{

    boolean jump(){
        Random random = new Random();
        int chance = random.nextInt(100);
        System.out.println(chance);
        if (chance >= 50){
            return true;
        } else {
            return false;
        }
    }

    @Override
    void animalAction() {
        System.out.println("Вы видите ЗАЙЦА!\nВаши действия: \n>1.Стреляем! \n>2.Перезарядка");
    }

}
