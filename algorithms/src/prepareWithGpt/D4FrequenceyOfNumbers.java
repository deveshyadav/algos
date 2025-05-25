package prepareWithGpt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D4FrequenceyOfNumbers {

    public static void main(String[] args) {
        List<Integer> list = List.of(3,3,3,3,1,2,4,5,6);
        int res = majorityElement(list);
        System.out.println(res);
    }

    private static int getNumberIfFrequencyMoreThanHalfSize(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = list.size();
        int maxFreq = 0;
        for(int i:list){
            int temp = map.getOrDefault(i,0);
            map.put(i,temp+1);
            if(temp+1 > maxFreq) {
                maxFreq = temp + 1;
                if(maxFreq > n/2){
                    return i;
                }
            }
        }
        return -1;
    }

    //Majority means occurance > n/2.
    // So this is boyce moore algo which works only if there is guarantee of majority element
    public static int majorityElement(List<Integer> nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

       return candidate;
    }

}
