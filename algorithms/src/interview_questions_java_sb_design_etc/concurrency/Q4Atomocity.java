package interview_questions_java_sb_design_etc.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Q4Atomocity {

    public static void main(String[] args) {

        SharedCounter counter = new SharedCounter();

        AtomicCounter atomicCounter = new AtomicCounter();
        new Thread(){
            @Override
            public void run(){
                System.out.println("t1 started");

                for(int i=0;i<50000;i++){
                    counter.increment();
                }
                for(int i=0;i<50000;i++){
                    atomicCounter.increment();
                }
                System.out.println("T1 Shared Increment done " + counter.getCount());
                System.out.println("T1 Atomic Increment done " + atomicCounter.getCount());
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("t2 started");

                for(int i=0;i<50000;i++){
                    counter.increment();
                }

                for(int i=0;i<50000;i++){
                    atomicCounter.increment();
                }
                System.out.println("T2 Shared Increment done " + counter.getCount());
                System.out.println("T2 Atomic Increment done " + atomicCounter.getCount());
            }
        }.start();

        try {

            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Final shared count: " + counter.count);
        System.out.println("Final atomic count: " + atomicCounter.count);
    }

    static class SharedCounter{
        private int count;

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }

    static class AtomicCounter{
        private final AtomicInteger count =  new AtomicInteger(0);

        public AtomicInteger getCount() {
            return count;
        }

        public void increment() {
            count.incrementAndGet();
        }
    }
}
