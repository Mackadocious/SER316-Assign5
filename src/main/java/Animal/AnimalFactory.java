package Animal;

/**
 * The type Animal factory.
 */
public class AnimalFactory {

    /**
     * Create animal animal.
     *
     * @param input the input
     * @return the animal
     */
    public Animal createAnimal(int input) {
        if (input == 0) {
            return new Horse();

        } else if (input == 1) {
            return new Cow();
        } else if (input == 2) {
            return new Sheep();
        } else {
            return null;
        }
    }
}
