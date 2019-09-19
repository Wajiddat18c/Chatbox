import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    static final int MAX_T = 5;

    public static void main(String[] args) {
        Runnable r1 = new ServerTest("Task 1", 6000);
        Runnable r2 = new ServerTest("Task 2", 7000);
        Runnable r3 = new ServerTest("Task 3", 8000);
        Runnable r4 = new ServerTest("Task 4", 9000);
        Runnable r5 = new ServerTest("Task 5", 10000);


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
