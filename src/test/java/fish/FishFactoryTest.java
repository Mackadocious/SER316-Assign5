package fish;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;



public class FishFactoryTest {
    FishFactory animalFactory;

    @Before
    public void setUp() throws Exception {
        animalFactory = new FishFactory();

    }

    @Test
    public void createFish() {
        Fish animal;
        animal = animalFactory.createFish(0);
        assertTrue(animal.getType().equalsIgnoreCase("salmon"));
        animal = animalFactory.createFish(1);
        assertTrue(animal.getType().equalsIgnoreCase("tuna"));
        animal = animalFactory.createFish(2);
        assertTrue(animal.getType().equalsIgnoreCase("cod"));
        animal = animalFactory.createFish(5);
        assertTrue(animal == null);

    }

}
