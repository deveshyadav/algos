package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class PermuteLetterCases {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        String s = "AB";
        ArrayList<String> res = new ArrayList<>();
        permute(s.toCharArray(), res,0);
        System.out.println(res);

    }

    private static void permute(char[] arr,
                                ArrayList<String> res, Integer index) {
        if(index == arr.length) {
            res.add(new String(arr));
            return;
        }
            char cr = arr[index];
            if(Character.isLetter(cr)) {
                arr[index] = Character.toLowerCase(cr);
                permute(arr, res, index+1);

                arr[index] = Character.toUpperCase(cr);
                permute(arr, res, index+1);
                //[AB, Ab, aB, ab]
                //arr[index] = cr;
            }else{
                permute(arr, res, index+1);
            }


    }


}
