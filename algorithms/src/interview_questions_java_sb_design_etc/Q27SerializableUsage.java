package interview_questions_java_sb_design_etc;

import java.io.*;

public class Q27SerializableUsage {
        public static void main(String[] args) {
            Person person = new Person("Bob", 25);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person"))) {
                out.writeObject(person);  // This will throw exception
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

// Not implementing Serializable (Need to implement Serializable)
    class Person implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
