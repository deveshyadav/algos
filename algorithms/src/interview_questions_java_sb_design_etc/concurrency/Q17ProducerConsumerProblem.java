package interview_questions_java_sb_design_etc.concurrency;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Q17ProducerConsumerProblem {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        ConsumerBlockingQueue consumerBlockingQueue = new ConsumerBlockingQueue(blockingQueue);
        ProducerBlockingQueue producerBlockingQueue = new ProducerBlockingQueue(blockingQueue);

        Thread p = new Thread(producerBlockingQueue);
        Thread c = new Thread(consumerBlockingQueue);

        p.start();
        c.start();
    }

    static class ConsumerBlockingQueue implements Runnable{

        private final BlockingQueue<Integer> queue;

        public ConsumerBlockingQueue(BlockingQueue<Integer> queue){
            this.queue=queue;
        }

        @Override
        public void run() {

                try {
                    while (true) {
                        Integer item = queue.take();
                        System.out.println("ConsumedItem: "+item);
                        Thread.sleep(2000);
                    }
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
    }

    static class ProducerBlockingQueue implements Runnable{
        private final BlockingQueue<Integer> queue;
        public ProducerBlockingQueue(BlockingQueue<Integer> queue){
            this.queue=queue;
        }

        @Override
        public void run() {
            try{
                for(int i=0;i<100;i++){
                    Thread.sleep(1000);
                    queue.put(i);
                    System.out.println("Produced: "+i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}





