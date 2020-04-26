package Farmers;

import java.util.Random;

/**
 * The type Cash farmer.
 */
public class CashFarmer implements Farmer {


    /**
     * The Type.
     */
    public final String TYPE = "animal";
    /**
     * The Skill.
     */
    int skill;

    /**
     * The Random.
     */
    Random random;

    /**
     * Instantiates a new Cash farmer.
     */
    public CashFarmer() {
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
