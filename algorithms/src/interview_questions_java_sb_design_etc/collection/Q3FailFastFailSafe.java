package interview_questions_java_sb_design_etc.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q3FailFastFailSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc1");

        for (String s : list) {
            // list.add("abc2");  //Fail-fast ConcurrentModificationException
            System.out.println(s);
        }

        List<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("abc");
        list1.add("abc1");

        for (String s : list1) {
            list1.add("abc2"); //Fail-safe ConcurrentModificationException
            System.out.println(s);
        }

    }
}
