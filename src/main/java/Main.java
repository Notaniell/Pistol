import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Шестизарядный револьвер");
            System.out.println("1. Зарядить магазин");
            System.out.println("2. Выстрелиить");
            System.out.println("3. Сколько патронов осталось");
            System.out.println("4. Наигрались и хватит, выходим");

            Scanner scanner = new Scanner(System.in);

            if (!scanner.hasNextInt()){
                System.out.println("Ошибка: нужно ввести целое число!");
                scanner.next();
            } else {
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        Magazine.loadMagazine();
                        break;
                    case 2:
                        Pistol.shot();
                        break;
                    case 3:
                        System.out.println("Осталось патронов: " + Magazine.currentBullet);
                        break;
                    case 4:
                        System.out.println("Ну чтож пока, пока");
                        return;
                    default:
                        System.out.println("Давай нормально, выбери от 1 до 4");
                }
            }
        }
    }
}
