package monthmarathon.leetcode.TwoPointer.fifteen_june;

import java.util.*;

public class ThreeSumAll {

    public static void main(String[] args) {
        int[] arr =  new int[]{0,0,0,0,0};
        List<List<Integer>> cont = threeSum(arr,0);
        System.out.println("Triplets-  " + cont);
    }

    private static ArrayList<ArrayList<Integer>> getTarget(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i= 0;i<n-2;i++){
            int left =i+1;
            int right = n-1;
            if(i>0 && arr[i]!=arr[i+1]) continue;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(arr[i],arr[left],arr[right])));
                    left++;
                    right--;
                } else if(sum>0) right--;
                else left++;
            }
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> getTarget1(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i= 0;i<n-2;i++){
            int left =i+1;
            int right = n-1;
            if(i>0 && arr[i]!=arr[i+1]) continue;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(arr[i],arr[left],arr[right])));
                    left++;
                    right--;
                } else if(sum>0) right--;
                else left++;
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            if(i>0 && arr[i]!=arr[i+1]) continue;
            int finalI = i;
            List<List<Integer>> temp = new ArrayList<>(twoSum(arr, target - arr[i]));

            temp.forEach(x -> {
                x.add(0,arr[finalI]);
            });
            res.addAll(temp);
        }

        return res;
    }



    private static List<List<Integer>> twoSum(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int j : arr) {
            if (seen.containsKey(target - j)) {
                List<Integer> temp = new ArrayList<>(List.of(j, target - j));
                if(!res.contains(temp)) {
                    res.add(temp);
                }
            } else {
                seen.put(j , 1);
            }
        }
        return res;
    }


}
