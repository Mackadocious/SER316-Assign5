package predator;

/**
 * The type Coyotes.
 */
public class Coyotes implements Predator {
    /**
     * The Type.
     */
    final String type = "Coyotes";
    /**
     * The Skill level.
     */
    int skillLevel;

    /**
     * Instantiates a new Coyotes.
     */
    public Coyotes() {
        skillLevel = 1;
    }


    @Override
    public void incrementPredatorSkillLevel() {
        this.skillLevel++;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getSkillLevel() {
        return this.skillLevel;
    }

    @Override
    public void incrementPreadtorSkillLevel() {

    }
}
