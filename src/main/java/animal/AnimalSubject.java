package animal;


/**
 * The interface Animal subject.
 */
public interface AnimalSubject {
    /**
     * Register.
     *
     * @param o the o
     */
    public void register(AnimalObserver o);

    /**
     * Unregister.
     *
     * @param o the o
     */
    public void unregister(AnimalObserver o);

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
