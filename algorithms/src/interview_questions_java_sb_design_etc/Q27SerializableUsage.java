package interview_questions_java_sb_design_etc;

import java.io.*;

public class Q27SerializableUsage {
    public static void main(String[] args) {
        Person person = new Person("Bob", 22);

        File file = new File("person.txt");
        System.out.println("Writing to: " + file.getAbsolutePath());

        // Use try-with-resources to ensure the stream is closed
       try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }



        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Person p = (Person) in.readObject();
            System.out.println("Read person: " + p.name + ", " + p.age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Not implementing Serializable (Need to implement Serializable)
    class Person implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
