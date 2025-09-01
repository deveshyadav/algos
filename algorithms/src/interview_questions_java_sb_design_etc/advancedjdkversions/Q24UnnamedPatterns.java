/*
package interview_questions_java_sb_design_etc.advancedjdkversions;

//Java 21 feature
public class Q24UnnamedPatterns {

        public static void main(String[] args) {
            Object input = (Object) 123;

            // 1. switch expression using underscore
            String result = switch (input) {
                case String _ -> "It's a String (ignored) ";
                case Integer _ -> "It's an Integer (ignored)";
                case null -> "It's null";
                default -> "Something else";
            };
            System.out.println(result);

            // 2. instanceof pattern using underscore
            if (input instanceof Integer _) {
                System.out.println("Confirmed: input is an Integer, but I don't need its value");
            }

            // 3. Record pattern with ignored components
            record Point(int x, int y) {}
            Point p = new Point(10, 20);

            if (p instanceof Point(int _, int y)) {
                System.out.println("Only interested in y: " + y);
            }

            // 4. Enhanced for-loop with unused variable
            for (String _ : java.util.List.of("A", "B", "C")) {
                System.out.println("Looping without using the value");
            }
        }
    }
*/
