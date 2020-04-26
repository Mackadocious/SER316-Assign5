package farmers;

import java.util.Random;

/**
 * The type Crop farmer.
 */
public class CropFarmer implements Farmer {
    /**
     * The Type.
     */
    public static final String type = "crops";
    /**
     * The Skill.
     */
    int skill;


    /**
     * Instantiates a new Crop farmer.
     */

    public CropFarmer() {


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
        return this.type;
    }
}
