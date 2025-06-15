package leetcode.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ThreeNumTargetSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        ArrayList<Integer> input  = new ArrayList<>(IntStream.of(arr).boxed().toList());
        ArrayList<ArrayList<Integer>> res = getRes(input);
        System.out.println("wew"+res.isEmpty());
        res.forEach(System.out::println);
    }

    private static ArrayList<ArrayList<Integer>> getRes(ArrayList<Integer> input) {
        int n = input.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-2;i++){

            if(i>0 && input.get(i).equals(input.get(i-1))) continue;

            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = input.get(i) + input.get(left) + input.get(right);

                if(sum==0) {

                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(input.get(i), input.get(left), input.get(right)));
                    res.add(temp);
                    while(left<right && input.get(left).equals(input.get(left+1))){
                        left++;
                    }
                    while(left<right && input.get(right).equals(input.get(right-1))){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum>0) right--;
                else left++;
            }
        }
        return res;
    }


}
