package crops;


/**
 * The type Crops factory.
 */
public class CropsFactory {

    /**
     * Create crops crops.
     *
     * @param input the input
     * @return the crops
     */
    public Crops createCrops(int input) {
        if (input == 0) {
            return new Barley();

        } else if (input == 1) {
            return new Hay();
        } else if (input == 2) {
            return new Wheat();
        } else {
            return null;
        }
    }
}
