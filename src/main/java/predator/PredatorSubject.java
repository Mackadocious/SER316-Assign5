package predator;

/**
 * The interface Predator subject.
 */
public interface PredatorSubject {

    /**
     * Register.
     *
     * @param newObserver the new observer
     */
    public void register(PredatorObserver newObserver);

    /**
     * Unregsiter.
     *
     * @param o the o
     */
    public void unregsiter(PredatorObserver o);

}
