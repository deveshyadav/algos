package design.patterns.creational;

public class Factory {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.getAnimal("dog");
        animal.eat();
    }

    interface Animal{
        public abstract void eat();
    }

    static class Dog implements Animal{
        @Override
        public void eat() {
            System.out.println("Dog eating");
        }
    }

    static class Cat implements Animal{
        @Override
        public void eat() {
            System.out.println("Cat eating");
        }
    }

    static class AnimalFactory{
        public Animal getAnimal(String name){
            if("dog".equals(name)) return new Dog();
            else if ("cat".equals(name)) return new Cat();
            else return null;
        }
    }
}
