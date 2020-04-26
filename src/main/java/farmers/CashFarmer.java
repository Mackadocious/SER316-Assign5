package farmers;

import java.util.Random;

/**
 * The type Cash farmer.
 */
public class CashFarmer implements Farmer {


    /**
     * The Type.
     */
    public static final String type = "cash";
    /**
     * The Skill.
     */
    int skill;

    /**
     * Instantiates a new Cash farmer.
     */

    public CashFarmer() {

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
