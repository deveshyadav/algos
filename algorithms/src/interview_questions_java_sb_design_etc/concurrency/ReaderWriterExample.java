package interview_questions_java_sb_design_etc.concurrency;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterExample {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    int sharedData = 0;

    public void read(){
        //lock.readLock().lock();

        System.out.println("Reading:-"+Thread.currentThread().getName()+" "+sharedData);
        //lock.readLock().unlock();
    }

    public void write(int i){
        //lock.writeLock().lock();
        sharedData=i;
        System.out.println("Increased to:-"+Thread.currentThread().getName()+" "+sharedData);
       // lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        ReaderWriterExample resource = new ReaderWriterExample();
        Runnable read = resource::read;
        Runnable write = ()-> resource.write((int) (Math.random() * 100));

        for(int i=0;i<4;i++){
            new Thread(read, "Readertask:"+i).start();
        }
        for(int i=0;i<4;i++){
            new Thread(write, "Writertask:"+i).start();
        }

    }
}

