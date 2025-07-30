package design.patterns.creational;

public class Prototype {

    static class A implements Cloneable{

        int a;
      public A(int a){
          this.a=a;
      }

      @Override
        public A clone(){
            return new A(this.a);
        }
    }
}
