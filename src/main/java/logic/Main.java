package logic;

import java.util.Scanner;


/**
 * The type Main.
 */
class Main {
    protected static GameSingleton game = null;
    private static boolean playing;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {
        playing = true;
        gameLoop();


    }

    private static void gameLoop() {
        Scanner scan = new Scanner(System.in, "UTF-8");


        game = GameSingleton.getInstance();
        while (playing) {

            System.out.println("Would you like to run another 10 ticks? y/n");
            String option = "";
            option = scan.nextLine();

            if (option.equalsIgnoreCase("y")) {
                game.runGame();

            } else if (option.equalsIgnoreCase("n")) {
                playing = false;
                break;
            } else {
                playing = false;
                break;
            }
        }
    }


}