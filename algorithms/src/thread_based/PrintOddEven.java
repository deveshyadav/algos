package thread_based;

public class PrintOddEven {


    final Object lock = new Object();
    int number = 1;
    int max = 100;

    public static void main(String[] args) {
        PrintOddEven printOddEven = new PrintOddEven();
        int[] arr = new int[100];
        Thread t1 = new Thread(printOddEven::printOdd,"evenThread");
        Thread t2 = new Thread(printOddEven::printEven,"oddThread");


        t2.start();
        t1.start();
    }

    private void printOdd(){

        synchronized (lock) {
            while(number<=max){
                if(number%2 != 0){
                    System.out.println(number);
                    number++;
                    lock.notify();
                }
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            lock.notify();
        }

    }

    private void printEven(){
        synchronized (lock) {
            while(number<=max){
                if(number%2==0){
                    System.out.println(number);
                    number ++;
                    lock.notify();
                }
                else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        lock.notify();
    }
}
