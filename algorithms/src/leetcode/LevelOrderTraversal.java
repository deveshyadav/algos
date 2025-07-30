package leetcode;

import java.util.LinkedList;
import java.util.Queue;

@FunctionalInterface
interface NumberComparator{
    boolean compare(int a, int b);
}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        NumberComparator nc = (a,b)-> {return a>b;};

        System.out.println(nc.compare(15,10));
    }
}
