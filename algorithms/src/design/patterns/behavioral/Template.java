package design.patterns.behavioral;

public class Template {
    public static void main(String[] args) {
        BeverageMaker bm = new CoffeeMaker();
        bm.makeBeverage();
    }
}

abstract class BeverageMaker{
    void makeBeverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater(){
        System.out.println("Boiling water");
    }
    private void pourInCup(){
        System.out.println("Puring in cup");
    }

    abstract void brew();
    abstract void addCondiments();
}

class TeaMaker extends BeverageMaker{

    @Override
    void brew() {
        System.out.println("Adding tea leaves");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar");
    }
}

class CoffeeMaker extends BeverageMaker{

    @Override
    void brew() {
        System.out.println("Adding coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}