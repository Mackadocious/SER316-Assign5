package Predator;

/**
 * The type Coyotes.
 */
public class Coyotes implements Predator {
    /**
     * The Skill level.
     */
    int skillLevel;
    /**
     * The Type.
     */
    final String TYPE = "Coyotes";

    /**
     * Instantiates a new Coyotes.
     */
    public Coyotes(){
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
