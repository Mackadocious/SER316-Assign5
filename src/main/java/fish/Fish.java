package fish;

public interface Fish extends FishObserver {
    boolean getDiseased();

    public int getRandomCount(int chance);

    public void setInventoryCount();

    int getInventory();

    void setInventory(int p);

    String getType();

    String getProductType();

    int getLife();


}
