package interview_questions_java_sb_design_etc.concurrency;

public class Q19VirtualThreads {

    public static void main(String[] args) {

        Runnable runnable = ()-> {
            try {
                Thread.sleep(100);
                System.out.println("Runnable: "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        for(int i=0;i<Integer.MAX_VALUE;i++){
            Thread t = new Thread(runnable);//This way not possible for system to create so many threads.

            //Thread t = Thread.ofVirtual().unstarted(runnable);
            // We are good to go with this with java 21. These are
            //This will easily create millions of threads —
            // because virtual threads are lightweight and scheduled by the JVM, not the OS.

            t.setDaemon(true);
            t.start();
            System.out.println("Thread number started: "+i);
        }
    }
}
