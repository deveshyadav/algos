package interview_questions_java_sb_design_etc.concurrency;

public class Singleton {

    private Singleton(){}

    static class Holder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return Holder.INSTANCE;
    }
}

class ss{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
