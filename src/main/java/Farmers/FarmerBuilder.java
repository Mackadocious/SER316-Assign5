package Farmers;

import Farms.Farm;
import Farms.FarmBuilder;

import java.util.Random;

public class FarmerBuilder {



    public static Farmer createFarmer(){
        Farmer farmer;
        Random random = new Random();
        int chance = random.nextInt(2);
        switch (chance) {
            case 0:
                farmer = new CropFarmer();
                break;
            case 1:
                farmer = new AnimalFarmer();
                break;

            case 2:
                farmer = new CashFarmer();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + chance);
        }
        farmer.setSkill(generateSkillLevel(farmer));
        return farmer;

    }

    private static int generateSkillLevel(Farmer farmer) {
        Random rand = new Random();
        int skillLevel = rand.nextInt(10);
        return skillLevel;
    }


}
