import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRun {
    static final int MAX_T = 5;

    public static void main(String[] args) {
        Runnable r1 = new ServerThread("Task 1", 6000);
        Runnable r2 = new ServerThread("Task 2", 6001);
        Runnable r3 = new ServerThread("Task 3", 6002);
        Runnable r4 = new ServerThread("Task 4", 6003);
        Runnable r5 = new ServerThread("Task 5", 6004);


        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        // pool shutdown ( Step 4)
        pool.shutdown();

}
}
