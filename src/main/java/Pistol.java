
public class Pistol {

    private final Magazine magazine;

    public Pistol(Magazine magazine) {
        this.magazine = magazine;
    }

    public void shot() {

        if (magazine.isEmpty()) {
            System.out.println("Клац...");
            return;
        }

        System.out.println("Бах!!!");
        magazine.decreaseBullets();
    }
}