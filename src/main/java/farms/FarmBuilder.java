package farms;

import java.util.Random;

/**
 * The type Farm builder.
 */
public class FarmBuilder {
    /**
     * The Random.
     */
    static Random random;
    /**
     * The Farm.
     */
    static Farm farm;
    private static int farmCount;


    /**
     * Instantiates a new Farm builder.
     */
    public FarmBuilder() {
        random = new Random();

    }

    /**
     * Generate farm farm.
     *
     * @param type the type
     * @return the farm
     */
    public static Farm generateFarm(String type) {
        farm = setType(type);
        farmCount++;
        return farm;
    }


    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public static Farm setType(String type) {
        if (type.equalsIgnoreCase("animal")) {
            return new AnimalFarm("Farm" + farmCount);
        } else if (type.equalsIgnoreCase("crops")) {
            return new CropsFarm("Farm" + farmCount);
        } else {
            return new FishFarm("Farm" + farmCount);
        }

    }


}
