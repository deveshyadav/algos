package interview_questions_java_sb_design_etc.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q17ProducerConsumerProblemBQueue {
    BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
    public void read(){
        try {
            System.out.println("Reading : "+bq.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void write(int i){
        System.out.println("Writing : "+i);
        try {
            bq.put(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Q17ProducerConsumerProblemBQueue bqTest = new Q17ProducerConsumerProblemBQueue();
        Runnable consumer = bqTest::read;
        Runnable producer = ()->bqTest.write((int) (Math.random()*100));

        for(int i=0;i<10;i++){
            new Thread(consumer).start();
        }

        for(int i=0;i<10;i++){
            new Thread(producer).start();
        }
    }

}





