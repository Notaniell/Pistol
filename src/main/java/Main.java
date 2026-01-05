import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readLoadBullet();

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
                        writeLoadBullet();
                        System.out.println("Ну чтож пока, пока");
                        return;
                    default:
                        System.out.println("Давай нормально, выбери от 1 до 4");
                }
            }
        }
    }

    public static void writeLoadBullet () {
        try (FileWriter writer = new FileWriter("remainBullets.txt")) {
            writer.write(Integer.toString(Magazine.currentBullet));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readLoadBullet() {
        File file = new File("remainBullets.txt");

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextInt()) {
                Magazine.currentBullet = scanner.nextInt();
            } else {
                System.out.println("Файл не содержит целых чисел");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка доступа к файлу");
        }
    }
}
