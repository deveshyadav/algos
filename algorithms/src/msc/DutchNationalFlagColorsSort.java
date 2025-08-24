package msc;

import java.util.ArrayList;
import java.util.Collections;

public class DutchNationalFlagColorsSort{

    public static void main(String[] args) {

        ArrayList<Character> arr = new ArrayList<>();
        Character[] chars = {'R','G','R','G','G','B','B','R','G','B'};
        Collections.addAll(arr, chars);
        rearrange(arr);
        arr.forEach(x-> System.out.println("->" + x));
    }

    private static void rearrange(ArrayList<Character> arr) {
        int low =0;
        int high = arr.size()-1;
        int mid = 0;

       while (mid<=high)
       {
           switch (arr.get(mid))
           {
               case 'R':
                   swap(arr, low, mid);
                   low++;
                   mid++;
                   break;

               case 'G':
                   mid++;
                   break;

               case 'B':
                   swap(arr, mid, high);
                   high--;
                   break;

           }
       }
    }

    static void swap(ArrayList<Character> arr, int i, int j) {
       if(arr.get(i) != arr.get(j)) {
           char temp = arr.get(i);
           arr.set(i, arr.get(j));
           arr.set(j, temp);
       }
    }

    static void print (ArrayList<Character> arr) {
        arr.forEach(x-> System.out.print("->" + x));
        System.out.println();
    }


}

