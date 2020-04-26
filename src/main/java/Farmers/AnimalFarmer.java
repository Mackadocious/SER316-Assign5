package Farmers;

import java.util.Random;

/**
 * The type Animal farmer.
 */
public class AnimalFarmer implements Farmer {
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
     * Instantiates a new Animal farmer.
     */
    public AnimalFarmer() {
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
