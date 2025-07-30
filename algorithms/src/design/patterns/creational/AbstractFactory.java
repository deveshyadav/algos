package design.patterns.creational;

public class AbstractFactory {
    public static void main(String[] args) {

        Factory factory;

        String factoryType = "modern";

        if(factoryType.equals("modern")) {
            factory = new ModernFactory();
        }
        else {
            factory = new ClassicFactory();
        }

        Shape shape = factory.getShape();
        Color color = factory.getColor();
        shape.getShape();
        color.getColor();
    }

    interface Color{
        public void getColor();
    }

    static class ModernColor implements Color{
        @Override
        public void getColor() {
            System.out.println("Modern color");
        }
    }

    static class ClassicColor implements Color{
        @Override
        public void getColor() {
            System.out.println("Classic color");
        }
    }

    interface Shape{
        public void getShape();
    }

    static class ModernShape implements Shape{

        @Override
        public void getShape() {
            System.out.println("Modern shape");
        }
    }

    static class ClassicShape implements Shape{

        @Override
        public void getShape() {
            System.out.println("Classic shape");
        }
    }

    interface Factory{
        Shape getShape();
        Color getColor();
    }

    static class ModernFactory implements Factory{

        @Override
        public Shape getShape() {
            return new ModernShape();
        }

        @Override
        public Color getColor() {
            return new ModernColor();
        }
    }

    static class ClassicFactory implements Factory{

        @Override
        public Shape getShape() {
            return new ClassicShape();
        }

        @Override
        public Color getColor() {
            return new ClassicColor();
        }
    }
}
