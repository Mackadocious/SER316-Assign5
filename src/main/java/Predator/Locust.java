package Predator;

/**
 * The type Locust.
 */
public class Locust implements Predator {

    /**
     * The Type.
     */
    final String TYPE = "Locust";
    /**
     * The Skill level.
     */
    int skillLevel;

    /**
     * Instantiates a new Locust.
     */
    public Locust() {
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
