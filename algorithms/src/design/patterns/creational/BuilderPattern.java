package design.patterns.creational;

public class BuilderPattern {

   static class A{
        int b;
        int c;

        private A(Builder builder){
            this.b=builder.b;
            this.c=builder.c;
        }

        static class Builder {
                int b;
                int c;
            public Builder setb(int b){
                this.b =b;
                return this;
            }

            public Builder setC(int c){
                this.c =c;
                return this;
            }

            public A build(){
                return new A(this);
            }

        }

    }
}
