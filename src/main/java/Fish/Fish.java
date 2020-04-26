package Fish;

public interface Fish extends FishObserver {
    boolean getDiseased();

    public int getRandomCount(int chance);

    public void setInventoryCount();

    int getInventory();

    String getType();

    String getProductType();

    void setInventory(int p);

    int getLife();


}
