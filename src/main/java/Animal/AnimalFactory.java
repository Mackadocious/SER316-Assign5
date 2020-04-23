package Animal;

public class AnimalFactory {

    public Animal createAnimal(String input) {
        if (input.equalsIgnoreCase("horse")) {
            return new Horse();
        } else if (input.equalsIgnoreCase("cow")) {
            return new Cow();
        } else if (input.equalsIgnoreCase("pig")) {
            return new Pig();
        } else {
            return null;
        }
    }
}
