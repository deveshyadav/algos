package interview_questions_java_sb_design_etc.generics;

public class Q1LegacyVsGeneric {

    public static void main(String[] args) {
        LegacyBox legacyBox = new LegacyBox();
        legacyBox.setValue(123);
        System.out.println(legacyBox.getValue());

        legacyBox.setValue("string value");
        //System.out.println(Integer.valueOf((int)legacyBox.getValue()));
        // No compile error. Fails at runtime with ClassCastException

        GenericBox<Integer> genericBox = new GenericBox<>();
        genericBox.setValue(123);
        System.out.println(genericBox.getValue());

        //genericBox.setValue("str"); Compile error for string

    }

    static class GenericBox<T>{
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    static class LegacyBox{
        private Object value;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
