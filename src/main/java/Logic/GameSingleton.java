package Logic;

public final class GameSingleton {

    private static GameSingleton instance = null;


    private GameSingleton() {

    }

    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }




}
