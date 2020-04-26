package crops;

/**
 * The interface Crops observer.
 */
public interface CropsObserver {
    /**
     * Sets sick.
     */
    public void setSick();

    /**
     * Sets well.
     */
    public void setWell();

    /**
     * Remove life.
     */
    public void removeLife();

    /**
     * Add to inventory.
     */
    void addToInventory();
}
