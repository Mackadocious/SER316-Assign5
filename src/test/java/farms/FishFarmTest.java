package farms;

import fish.FishGrabber;
import crops.Crops;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FishFarmTest{
    FishFarm farm;
    FarmGrabber grabber;

    @Test
    public void generatePassiveCurrency() {

        int currency = farm.getCurrency();
        farm.generatePassiveCurrency();
        assertTrue(currency + 200 == farm.getCurrency());
        for(int i = 0; i < 100; i++){
            farm.addFarmer();
        }
        farm.generatePassiveCurrency();
        assertTrue(currency < farm.getCurrency());
        for(int i = 0; i < 100; i++){
            farm.addFarmer();
        }

    }



    @Test
    public void runInventory() {
        for(int i = 0; i < 100; i++) {
            farm.runInventory();
            farm.setNight();
        }
        grabber.setNight();
    }

    @Test
    public void register() {
    }

    @Test
    public void unregister() {
    }

    @Test
    public void notifyOfSick() {
    }

    @Test
    public void notifyOfWell() {
    }

    @Test
    public void notifyOfRemoveLife() {
    }

    @Test
    public void notfiyOfAddToInventory() {
    }

    @Test
    public void checkDeath() {
    }

    @Test
    public void getCurrency() {
    }

    @Test
    public void setCurrency() {
    }

    @Test
    public void sell() {
    }

    @Test
    public void generateFarmerCurrency() {
    }

    @Test
    public void getCycle() {

    }

    @Test
    public void incrementCycle() {
    }

    @Test
    public void checkInvetoryOnAllFarms() {
    }

    @Test
    public void setNight() {


    }

    @Test
    public void addPredator() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getFarmers() {
    }

    @Test
    public void incrementPreadtorSkillLevel() {
    }

    @Before
    public void setUp() throws Exception {
        farm = new FishFarm("farm1");
        grabber = new FarmGrabber();
    }

    @Test
    public void checkForBabies() {
        farm.setFishesSize(10000);
        for(int i = 0; i < 150; i++){
            farm.runInventory();
            farm.checkForBabies();

        }
    }
}