package fish;


/**
 * The interface Fish subject.
 */
public interface FishSubject {

    /**
     * Register.
     *
     * @param o the o
     */
    public void register(FishObserver o);

    /**
     * Unregister.
     *
     * @param o the o
     */
    public void unregister(FishObserver o);

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
