
import java.util.*;

public class TwoNumberSum {


    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6 ,8, 14, 0));
        int target = 14;
        Collections.sort(numbers);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.size(); i++)
        {
            int n = numbers.get(i);
            //System.out.println(map);
            if(map.containsKey(target-n))
                System.out.println("Pair:-" + n + "," + (target-n));
            else map.put(n, i);
        }

    }


}
