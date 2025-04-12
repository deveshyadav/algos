package recursion;

import java.util.*;

public class WordsFromPhoneNumber {

    static Map<Character,List<Character>> map = new HashMap<>();

    static {
        map.put('1', List.of('a', 'b', 'c'));
        map.put('2', List.of('d', 'e', 'e'));
        map.put('3', List.of('f', 'g', 'h'));
        map.put('4', List.of('i', 'j', 'k'));
        map.put('5', List.of('l', 'm', 'n'));
        map.put('6', List.of('o', 'p', 'q'));
        map.put('7', List.of('r', 's', 't'));
        map.put('8', List.of('u', 'v', 'w'));
        map.put('9', List.of('x', 'y', 'z'));
        map.put('0', Collections.emptyList());
    }
    public static void main(String[] args) {
        String phoneNumber = "123";
        char[] arr = phoneNumber.toCharArray();
        ArrayList<String> res = new ArrayList<>();

        permute(res, arr, new StringBuilder());
        res.forEach(System.out::println);
    }

    static void permute(ArrayList<String> res, char[] arr, StringBuilder sb){
        if(sb.length() == arr.length){
            res.add(String.valueOf(sb));
            return;
        }
        for(int i=0;i<arr.length;i++){

            //System.out.println(sb);
            sb.append(map.get(arr[i]).get(0));
            permute(res, arr, sb);
            sb.deleteCharAt(sb.length()-1);

            //System.out.println(i);
           // System.out.println(arr[map.get(arr[i]));
            sb.append(map.get(arr[i]).get(1));
            permute(res, arr, sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(map.get(arr[i]).get(2));
            permute(res, arr, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
