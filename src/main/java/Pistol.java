public class Pistol {
    public static void shot() {
        if (Magazine.currentBullet > 0) {
            System.out.println("Бах!!!");
            Magazine.currentBullet--;
        } else {
            System.out.println("Клац...");
        }

    }
}