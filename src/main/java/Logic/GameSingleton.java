package Logic;

import Farmers.Farmer;
import Farms.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Game singleton.
 */
public final class GameSingleton implements FarmSubject {
    /**
     * The constant instance.
     */
    public static GameSingleton instance = null;
    /**
     * The Farm grabber.
     */
    FarmGrabber farmGrabber = new FarmGrabber();
    /**
     * The Log.
     */
    String log = "";
    /**
     * The Day.
     */
    boolean day = true;
    /**
     * The Farms.
     */
    ArrayList<Farm> farms;
    /**
     * The Cycle count.
     */
    int cycleCount;
    /**
     * The Night cycle count.
     */
    int nightCycleCount;
    /**
     * The Day cycle count.
     */
    int dayCycleCount;
    private FarmBuilder farmBuilder;


    private GameSingleton() {
        farms = new ArrayList<>();
        Farm farm = chooseFarm();
        farms.add(farm); //creates the first farm.
        register(farm);
        runGame();


    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }

    private Farm chooseFarm() {
        Random random = new Random();
        int chance = random.nextInt(3); //change to 3 when fish farms are implemented
        Farm chosenFarm;

        switch (chance) {
            case 0:
                chosenFarm = FarmBuilder.generateFarm("crops");
                break;
            case 1:
                chosenFarm = FarmBuilder.generateFarm("animal");
                break;

            case 2:
                chosenFarm = FarmBuilder.generateFarm("fish");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + chance);
        }
        return chosenFarm;

    }

    /**
     * Run game.
     */
    void runGame() {
        for (int loop = 0; loop < 10; loop++) { //cycle loop
            dayCycleCount++;

            notifyCheckInventory();
            day = false; //start night cycle
            nightCycleCount++;

            farmGrabber.setNight(); //sets night and starts predators on all farms

            day = true; //end night cycle
            cycleCount++;
            checkForUpgrades();
            System.out.println("End Cycle\n----------------------");
        }
        System.out.println("Cycles: " + cycleCount);


    }

    private void checkForUpgrades() {
        for (int i = 0; i < farms.size(); i++) {
            ArrayList<Farmer> farmers = farms.get(i).getFarmers();
            if (farms.get(i).getCurrency() > 1000 && farmers.size() == 10) {
                System.out.println(farms.get(i).getName() + " has bought a new farm. -1000 currency, -3 farmers");
                farms.get(i).setCurrency(farms.get(i).getCurrency() - 500);
                farmers.remove(farmers.size() - 1);
                farmers.remove(farmers.size() - 1);
                farmers.remove(farmers.size() - 1);
                Farm farm = chooseFarm();
                register(farm);
                farms.add(farm);
                farm.addFarmer();
                farm.addFarmer();

            }
        }
    }


    @Override
    public void notifyCheckInventory() {
        farmGrabber.notifyCheckInventory();
    }

    @Override
    public void register(FarmObserver o) {
        farmGrabber.register(o);
    }

    @Override
    public void unregister(FarmObserver o) {
        farmGrabber.unregister(o);
    }
}
