package interview_questions_java_sb_design_etc.concurrency;

public class Q20ThreadLocal {
        // Each thread gets its own copy of this variable
        private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

        private static String sharedValue;

        public static void main(String[] args) {
            Runnable task = () -> {
                // Set value specific to current thread
                threadLocal.set("Value for " + Thread.currentThread().getName());

                // Simulate some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                // Get the thread-specific value
                System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
            };

            // Start two threads
            Thread t1 = new Thread(task, "Thread-A");
            Thread t2 = new Thread(task, "Thread-B");

            t1.start();
            t2.start();


            //Without Thread local same code

            Runnable task1 = () -> {
                sharedValue = "Value for " + Thread.currentThread().getName();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                System.out.println(Thread.currentThread().getName() + " => " + sharedValue);
            };

            Thread t3 = new Thread(task1, "Thread-C");
            Thread t4 = new Thread(task1, "Thread-D");

            t3.start();
            t4.start();
        }
    }
