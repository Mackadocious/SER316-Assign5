package fish;


/**
 * The type Fish factory.
 */
public class FishFactory {

    /**
     * Create fish fish.
     *
     * @param input the input
     * @return the fish
     */
    public Fish createFish(int input) {
        if (input == 0) {
            return new Salmon();

        } else if (input == 1) {
            return new Tuna();
        } else if (input == 2) {
            return new Cod();
        } else {
            return null;
        }
    }
}
