package farmers;

import java.util.Random;

/**
 * The type Farmer builder.
 */
public class FarmerBuilder {


    /**
     * Create farmer farmer.
     *
     * @return the farmer
     */
    public static Farmer createFarmer() {
        Farmer farmer;
        Random random = new Random();
        int chance = random.nextInt(3);
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
            case 3:
                farmer = new FishFarmer();

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
