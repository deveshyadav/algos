package design.patterns.structural;

public class Adapter {

    static class A{
        String aName;
        String aAge;
        public String getName(){
            return this.aName;
        }

        public String getAge(){
            return this.aAge;
        }
    }

    static class B{
        String bName;
        String bAge;
        B(String bName, String bAge){
            this.bName = bName;
            this.bAge = bAge;
        }
    }

    public B adapter(A a){
        B b = new B(a.getName(),a.getAge());
        return b;
    }
}
