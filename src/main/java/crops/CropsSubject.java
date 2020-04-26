package crops;


/**
 * The interface Crops subject.
 */
public interface CropsSubject {

    /**
     * Register.
     *
     * @param o the o
     */
    public void register(CropsObserver o);

    /**
     * Unregister.
     *
     * @param o the o
     */
    public void unregister(CropsObserver o);

    /**
     * Notify of sick.
     */
    public void notifyOfSick();

    /**
     * Notify of well.
     */
    public void notifyOfWell();

    /**
     * Notify of remove life.
     */
    public void notifyOfRemoveLife();

    /**
     * Notfiy of add to inventory.
     */
    public void notfiyOfAddToInventory();
}
