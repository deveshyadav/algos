package interview_questions_java_sb_design_etc.concurrency;

public class Q7VolatileVisibility {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();
        new Thread(){
            @Override
            public void run(){
                System.out.println("T1 starts");
                try {
                    Thread.sleep(10000);
                    resource.setFlag(true);
                    System.out.println("T1 Completed and set flag to true");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("T2 starts");
                while (!resource.isFlag()){
                    //wait
                }
                System.out.println("T2 completed");
            }
        }.start();

    }

    static class SharedResource{
        private volatile boolean flag = false;

        public boolean isFlag() {
            return this.flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }
}
