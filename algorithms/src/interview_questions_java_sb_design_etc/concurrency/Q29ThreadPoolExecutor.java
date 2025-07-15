package interview_questions_java_sb_design_etc.concurrency;

import javax.crypto.Mac;
import java.util.concurrent.*;

public class Q29ThreadPoolExecutor {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*
        This is similar to this, with unbounded Q.
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
         */


        //That's why this is better.
        ExecutorService executorService1 = new ThreadPoolExecutor(0, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(5));

        for(int i=0;i<100;i++){
            final int taskId = i;
            executorService1.execute(()-> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(STR."Executor executing task: \{taskId}Executed by thread: \{
                        Thread.currentThread().getName()}");
            });
            System.out.println("Task done: "+taskId);
        }

    }
}
