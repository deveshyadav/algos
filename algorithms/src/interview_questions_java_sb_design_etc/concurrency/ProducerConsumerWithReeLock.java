package interview_questions_java_sb_design_etc.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithReeLock {
    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    Queue<Integer> qq = new LinkedList<>();

    public void read() {

        lock.lock();
        try {
            while (qq.isEmpty()) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + "is Reading:- " + qq.poll());
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public void write(int i){
        lock.lock();
        try {
            while (qq.size() >= 10) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            qq.offer(i);
            System.out.println(Thread.currentThread().getName() + "is Writing:-" + i);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ProducerConsumerWithReeLock pc = new ProducerConsumerWithReeLock();

        Runnable read = pc::read;
        Runnable write = ()->pc.write((int) (Math.random() * 100));

        for(int i=0;i<100;i++){
            new Thread(read, "ReadingThread"+i).start();
        }

        for(int i=0;i<100;i++){
            new Thread(write, "WritingThread"+i).start();
        }
    }
}
