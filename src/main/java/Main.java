import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static final String REMAIN_BULLETS = "fddddd.txt";

    public static void main(String[] args) {

        Magazine magazine = new Magazine(6);
        Pistol pistol = new Pistol(magazine);

        readLoadBullet(magazine);
        process(magazine, pistol);
    }

    private static void process(Magazine magazine, Pistol pistol) {
        while (true) {
            printHelp();
            ConsoleIO.printMainHelp();
            Integer input = getDigital();

            switch (input) {
                case 1 -> loadMagazine(magazine);
                case 2 -> pistol.shot();
                case 3 -> System.out.println("Осталось патронов: " + magazine.getCurrentBullets());
                case 4 -> {
                    writeLoadBullet(magazine);
                    System.out.println("Ну чтож пока, пока");
                    return;
                }
                case null -> {
                    continue;
                }
                default -> System.out.println("Давай нормально, выбери от 1 до 4");
            }
        }
    }

    private static void loadMagazine(Magazine magazine) {
        Integer bullets = ConsoleIO.getDigital();
        ConsoleIO.printHelpMagazine(magazine);

        if (bullets < 0) {
            System.out.println("Патроны не валидны!");
            return;
        }
        magazine.loadMagazine(bullets);
    }

//    private static void printHelpMagazine(Magazine magazine) {
//        int maxBullets = magazine.getMaxBullets();
//        int currentBullets = magazine.getCurrentBullets();
//
//        String message = String.format(
//                "Сколько патронов заряжаем? Сейчас в магазине %d.\nМаксимум %d. Можешь добавить %d",
//                currentBullets, maxBullets, maxBullets - currentBullets);
//        System.out.println(message);
//    }

    private static Integer getDigital() {
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести целое число!");
            scanner.next();
            return getDigital();
        }
        return scanner.nextInt();
    }

    private static void printHelp() {
        System.out.println("Шестизарядный револьвер");
        System.out.println("1. Зарядить магазин");
        System.out.println("2. Выстрелить");
        System.out.println("3. Сколько патронов осталось");
        System.out.println("4. Наигрались и хватит, выходим");
    }

    public static void writeLoadBullet(Magazine magazine) {
        try (FileWriter writer = new FileWriter(REMAIN_BULLETS)) {
            writer.write(Integer.toString(magazine.getCurrentBullets()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readLoadBullet(Magazine magazine) {
        File file = new File(REMAIN_BULLETS);

        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {

            if (!scanner.hasNextInt()) {
                System.out.println("Файл не содержит целых чисел");
                return;
            }
            magazine.loadMagazine(scanner.nextInt());

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка доступа к файлу");
        }
    }
}
