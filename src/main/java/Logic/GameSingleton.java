package Logic;

import Farms.*;

import java.util.ArrayList;
import java.util.Random;

public final class GameSingleton implements FarmSubject {
    public static GameSingleton instance = null;
    FarmGrabber farmGrabber = new FarmGrabber();
    String log = "";
    boolean day = true;
    ArrayList<Farm> farms;
    int cycleCount;
    int nightCycleCount;
    int dayCycleCount;
    private FarmBuilder farmBuilder;


    private GameSingleton() {
        farms = new ArrayList<>();
        Farm farm = chooseFarm();
        farms.add(farm); //creates the first farm.
        farmGrabber.register(farm);
        runGame();


    }

    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }

    private Farm chooseFarm() {
        Random random = new Random();
        int chance = random.nextInt(3);
        Farm chosenFarm;
        chance = 1; //TEMPORARY REMOVE TO GENERATE OTHER FARMS OTHER THAN ANIMAL
        switch (chance) {
            case 0:
                chosenFarm = FarmBuilder.generateFarm("crop");
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

    void runGame() {
        for (int loop = 0; loop < 10; loop++) { //cycle loop
            dayCycleCount++;

            farmGrabber.notifyCheckInventory();
            day = false; //start night cycle
            nightCycleCount++;

            day = true; //end night cycle
            cycleCount++;
            System.out.println("End Cycle");
        }
        System.out.println("Cycles: " + cycleCount);


    }


    @Override
    public void notifyCheckInventory() {

    }

    @Override
    public void register(FarmObserver o) {

    }

    @Override
    public void unregister(FarmObserver o) {

    }
}
