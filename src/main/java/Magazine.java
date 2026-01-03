import java.util.Scanner;

public class Magazine {
    static final int MAXBULLET = 6;
    public static int currentBullet;
    public static Scanner scanner = new Scanner(System.in);

    static void loadMagazine() {
        boolean loaded = false;

        while(!loaded) {
            System.out.println("Сколько патронов заряжаем? (0-6)");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести целое число!");
                scanner.next();
            } else {
                int input = scanner.nextInt();
                if (input < 0) {
                    System.out.println("Патроны не могут быть отрицательными!");
                } else if (input > MAXBULLET) {
                    System.out.println("Слышь у нас шестизарядный револьвер, понимаешь 6 патронов максимум!");
                } else {
                    currentBullet = input;
                    System.out.println("Вы зарядили патронов: " + input);
                    loaded = true;
                }
            }
        }

    }
}