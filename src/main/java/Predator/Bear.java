package Predator;

/**
 * The type Bear.
 */
public class Bear implements Predator {
    /**
     * The Type.
     */
    final String TYPE = "Bears";
    /**
     * The Skill level.
     */
    int skillLevel;

    /**
     * Instantiates a new Bear.
     */
    public Bear() {
        skillLevel = 1;
    }


    @Override
    public void incrementPredatorSkillLevel() {
        this.skillLevel++;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public int getSkillLevel() {
        return this.skillLevel;
    }

    @Override
    public void incrementPreadtorSkillLevel() {

    }
}
