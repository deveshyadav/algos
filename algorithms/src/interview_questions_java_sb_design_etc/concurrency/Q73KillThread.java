package interview_questions_java_sb_design_etc.concurrency;

/**
 * Using Thread.interrupt() to Stop a Running Thread
 *
 */
public class Q73KillThread {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);

        t1.start();
        Thread.sleep(3000); // Let the worker run for 3 seconds

        System.out.println("Main thread sending interrupt signal...");
        t1.interrupt(); // Interrupt the worker thread
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Worker thread is running...");
                    Thread.sleep(1000); // Simulate work
                }
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted during sleep.");
                Thread.currentThread().interrupt(); // Restore interrupt status if needed
            }
            System.out.println("Worker thread exiting gracefully.");
        }
    }
}
