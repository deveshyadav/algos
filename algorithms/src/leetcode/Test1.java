package leetcode;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 8, 4, 6, 7, 21, 3, 4, 8, 1, 2};
        int target = 14;
        int[][] res = get3NumsTargetSum(arr, target);
        //int[][] res = get2Sum(arr, target);
        for (int[] i : res)
            System.out.println(Arrays.toString(i));
    }

    private static int[][] get3NumsTargetSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> res  = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            int curr = arr[i];
            int left=i+1;
            int right=n-1;

            if(i>0 && arr[i]==arr[i-1]) continue;

            while(left<right){
                int sum = curr+arr[left]+arr[right];

                if(sum==target){
                    res.add(Arrays.asList(curr,arr[left],arr[right]));

                    while(left<right && arr[left] == arr[left+1]) left++;
                    while(left<right && arr[right] == arr[right-1]) right--;
                    left++;right--;
                } else if(sum<target){
                    left++;
                } else{
                    right--;
                }
            }
        }
        return res.stream().map(x-> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    private static int[][] get2Sum(int[] arr, int target){
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int j : arr) {
            int comp = target-j;
            boolean saw = seen.contains(comp);
            if (saw) {
                List<Integer> temp = Arrays.asList(Math.min(j,target-j), Math.max(target - j,j));
                res.add(temp);
            }
            seen.add(j);

        }
        return res.stream().map(x->x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}

