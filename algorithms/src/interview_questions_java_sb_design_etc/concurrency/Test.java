package interview_questions_java_sb_design_etc.concurrency;

public class Test {
    static volatile boolean bobReady = false;
    static volatile boolean aliceReady = false;

    public static void main(String[] args) {

        Thread bob = new Thread(()->{

                while(!aliceReady){
                    System.out.println("Making bob ready");
                    bobReady =true;
                }

                System.out.println("Bob processing finished");

        });

        Thread alice = new Thread(()->{
                while(!bobReady){
                    System.out.println("Making alice ready");
                    aliceReady =true;
                }
                System.out.println("Alice processing finished");
        });

        alice.start();
        bob.start();
    }
}
