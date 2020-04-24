package Farms;

import Farmers.AnimalFarmer;

import java.util.Random;

public class FarmBuilder {
    static Random random;
    static Farm farm;
    private static int farmCount;


    public FarmBuilder() {
        random = new Random();

    }

    public static Farm generateFarm(String type) {
        farm = setType(type);
        farmCount++;
        return farm;
    }




    }


    public static Farm setType(String type) {
        if (type.equalsIgnoreCase("animal")) {
            return new AnimalFarm("Farm" + farmCount);
        } else if (type.equalsIgnoreCase("crop")) {
            return new CropFarm("Farm" + farmCount);
        } else {
            return new HybridFarm("Farm" + farmCount);
        }

    }


}
