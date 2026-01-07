public class Magazine {

    public Magazine(int maxBullets) {
        this.maxBullets = maxBullets;
    }

    private final int maxBullets;
    private int currentBullets;

    public void loadMagazine(Integer bullets) {
        if (bullets + currentBullets > maxBullets) {
            System.out.println("Слышь у нас шестизарядный револьвер, понимаешь 6 патронов максимум!");
            return;
        }

        currentBullets += bullets;

        System.out.println("Вы зарядили патронов: " + bullets);

    }

    public boolean isEmpty() {
        return currentBullets == 0;
    }

    public void decreaseBullets() {
        currentBullets--;
    }

    public int getCurrentBullets() {
        return currentBullets;
    }

    public int getMaxBullets() {
        return maxBullets;
    }
}