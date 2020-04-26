package Farmers;

import java.util.Random;

/**
 * The type Crop farmer.
 */
public class CropFarmer implements Farmer {
    /**
     * The Type.
     */
    public final String TYPE = "crops";
    /**
     * The Skill.
     */
    int skill;

    /**
     * The Random.
     */
    Random random;

    /**
     * Instantiates a new Crop farmer.
     */
    public CropFarmer() {
        random = new Random();


    }

    @Override
    public int getSkill() {
        return this.skill;

    }

    @Override
    public void setSkill(int skill) {
        this.skill = skill;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }
}
