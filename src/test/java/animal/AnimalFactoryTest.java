package animal;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;



public class AnimalFactoryTest {
    AnimalFactory animalFactory;

    @Before
    public void setUp() throws Exception {
        animalFactory = new AnimalFactory();

    }

    @Test
    public void createAnimal() {
        Animal animal;
        animal = animalFactory.createAnimal(0);
        assertTrue(animal.getType().equalsIgnoreCase("horse"));
        animal = animalFactory.createAnimal(1);
        assertTrue(animal.getType().equalsIgnoreCase("cow"));
        animal = animalFactory.createAnimal(2);
        assertTrue(animal.getType().equalsIgnoreCase("sheep"));
        animal = animalFactory.createAnimal(5);
        assertTrue(animal == null);

    }

}
