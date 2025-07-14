package interview_questions_java_sb_design_etc.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2BoundedTypeParamGenerics {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,7,2,3);
        System.out.println(getMax(list));

        List<Double> list1 = Arrays.asList(1.0,5.0,7.0,2.0,3.0);
        System.out.println(getMax(list1));
    }

    static <T extends Number & Comparable<T>> T getMax(List<T> list){
        if(list==null || list.isEmpty() ) {
            throw new IllegalArgumentException("List is not valid");
        }

        T max = list.get(0);

        for(T val:list){
            if(val.compareTo(max) > 0){
                max = val;
            }
        }
        return max;
    }
}
