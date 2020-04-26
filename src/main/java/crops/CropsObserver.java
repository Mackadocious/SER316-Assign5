package crops;

public interface CropsObserver {
    public void setSick();

    public void setWell();

    public void removeLife();

    void addToInventory();
}
