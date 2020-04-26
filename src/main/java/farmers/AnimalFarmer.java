package farmers;

/**
 * The type Animal farmer.
 */
public class AnimalFarmer implements Farmer {
    /**
     * The Type.
     */
    public static final String type = "animal";
    /**
     * The Skill.
     */
    int skill;

    /**
     * Instantiates a new Animal farmer.
     */

    public AnimalFarmer() {


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
