package Logic;

import Farms.Farm;
import Farms.FarmBuilder;

import java.util.ArrayList;
import java.util.Random;

public final class GameSingleton {
    public static GameSingleton instance = null;
    String log = "";
    boolean day = true;
    ArrayList<Farm> farms;
    int cycleCount;
    int nightCycleCount;
    int dayCycleCount;
    private FarmBuilder farmBuilder;


    private GameSingleton() {
        farms = new ArrayList<>();
        farms.add(chooseFarm()); //creates the first farm.
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
        int chance = random.nextInt(2);
        Farm chosenFarm;
        switch (chance) {
            case 0:
                chosenFarm = FarmBuilder.generateFarm("crop");
                break;
            case 1:
                chosenFarm = FarmBuilder.generateFarm("animal");
                break;

            case 2:
                chosenFarm = FarmBuilder.generateFarm("hybrid");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + chance);
        }
        return chosenFarm;

    }

    void runGame() {
        for (int loop = 0; loop < 10; loop++) { //cycle loop
            dayCycleCount++;


            day = false; //start night cycle
            nightCycleCount++;

            day = true; //end night cycle
            cycleCount++;
        }
        System.out.println("Cycles: " + cycleCount);


    }


}
