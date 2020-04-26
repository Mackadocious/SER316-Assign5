package crops;

public interface Crops extends CropsObserver {
    boolean getDiseased();

    public int getRandomCount(int chance);

    public void setInventoryCount();

    int getInventory();

    void setInventory(int p);

    String getType();

    String getProductType();

    int getLife();


}
