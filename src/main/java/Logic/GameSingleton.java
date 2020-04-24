package Logic;

import Farms.FarmBuilder;

import java.util.ArrayList;
import java.util.Random;

public final class GameSingleton {

    private static GameSingleton instance = null;
    String log = "";
    boolean day = true;
    ArrayList<FarmBuilder> farms;



    private GameSingleton() {
        rungame();
        farms.add(chooseFarm());

    }

    private FarmBuilder chooseFarm() {
        Random random = new Random();
        int chance = random.nextInt(2);
        switch (chance){
            case 0:


        }


    }


    private void rungame() {



    }

    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }






}
