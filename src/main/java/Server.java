import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Server {

    public static void main(String[] args) throws InterruptedException {

        runServer();
    }

    public static void runServer() throws InterruptedException {
        InputThread background = new InputThread(new Server()).run();
        System.out.println("hello");
        TimeUnit.SECONDS.sleep(2);
    }
}

class InputThread {
    private final Server server;
    public InputThread(Server server) {
        this.server = server;
    }

    public InputThread run() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println("test");
        }
        return null;
    }
}