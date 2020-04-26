package predator;

/**
 * The type Predator factory.
 */
public class PredatorFactory {
    /**
     * Create predator predator.
     *
     * @param input the input
     * @return the predator
     */
    public Predator createPredator(int input) {
        if (input == 0) {
            return new Bear();

        } else if (input == 1) {
            return new Coyotes();
        } else if (input == 2) {
            return new Locust();
        } else {
            return null;
        }
    }
}
