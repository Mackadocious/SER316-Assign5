package predator;

/**
 * The interface Predator.
 */
public interface Predator extends PredatorObserver {
    /**
     * Increment predator skill level.
     */
    void incrementPredatorSkillLevel();

    /**
     * Gets type.
     *
     * @return the type
     */
    String getType();

    /**
     * Gets skill level.
     *
     * @return the skill level
     */
    int getSkillLevel();
}
