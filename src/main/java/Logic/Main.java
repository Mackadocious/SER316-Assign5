package Logic;

import java.util.Scanner;


class Main {
    private static GameSingleton game = null;
    private static boolean playing;


    public static void main(String[] args) throws InterruptedException {
        playing = true;
        gameLoop();


    }

    private static void gameLoop() {
        Scanner scan = new Scanner(System.in);


        game = GameSingleton.getInstance();
        while (playing) {

            //game logic here//


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