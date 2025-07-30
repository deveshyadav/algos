package interview_questions_java_sb_design_etc.concurrency;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int sharedData = 0;

    // Reader (multiple readers can access simultaneously)
    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + sharedData);
        } finally {
            lock.readLock().unlock();
        }
    }

    // Writer (only one writer at a time, exclusive)
    public void write(int value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing: " + value);
            sharedData = value;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReaderWriterExample resource = new ReaderWriterExample();

        Runnable readerTask = resource::read;
        Runnable writerTask = () -> resource.write((int) (Math.random() * 100));

        // Multiple readers
        for (int i = 0; i < 3; i++) {
            new Thread(readerTask, "Reader-" + i).start();
        }

        // Writers
        for (int i = 0; i < 2; i++) {
            new Thread(writerTask, "Writer-" + i).start();
        }
    }
}

