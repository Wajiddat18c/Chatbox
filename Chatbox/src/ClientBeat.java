import java.util.Scanner;
// TODO LAV EN HEARBEAT!
public class ClientBeat implements Runnable {

    Thread worker;
    int alive = 0;
Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while (true) {
            // Says "blah" every half second
            System.out.println("Are you still alive?");

            try {
                Thread.sleep(600);
                if (scanner.next().equals("yes")){
                    alive = 0;
                }else {
                    alive++;
                }
                if (alive == 3) {
                    worker.interrupt();
                }else if (scanner.next().equals("yes")){
                    System.out.println("Welcome back!");
                    break;
                }
            } catch (InterruptedException ie) {
                // nope
            }
        }
    }
}
