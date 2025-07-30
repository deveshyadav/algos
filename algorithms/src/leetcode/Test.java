package leetcode;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Parent {
    static void show(){ System.out.println("Parent"); }
}
class Child extends Parent {
    static void show(){ System.out.println("Child"); }
}
public class Test {
    public static void main(String[] args){
        Parent p = new Child();
        p.show();

        Map<Integer, String> set = new LinkedHashMap<>(2,0.75f,true);
        set.put(1,"on1");
        set.put(2,"2");
        set.put(3,"3");
        set.get(2);
        System.out.println(set.entrySet());

    }
}
