package design.patterns.structural;

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        MilkBeverage beverage = new MilkBeverage(coffee);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.getCost());
    }

}
interface Coffee{
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public int getCost() {
        return 5;
    }
}

class MilkBeverage implements Coffee{
    Coffee coffee;

    MilkBeverage(Coffee coffee){
        this.coffee=coffee;
    }

    @Override
    public String getDescription() {
        return STR."\{coffee.getDescription()} + Milk";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 2;
    }
}
