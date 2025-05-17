package recursion;

import java.util.*;

public class WordsFromPhoneNumber {

    static Map<Character,List<Character>> map = new HashMap<>();

    static {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        //map.put('0', Collections.emptyList());
        //map.put('1', Collections.emptyList());
    }
    public static void main(String[] args) {
        String phoneNumber = "1234567";
        char[] arr = phoneNumber.toCharArray();
        ArrayList<String> res = new ArrayList<>();

        permute1(res, phoneNumber, 0, new StringBuilder());
        res.forEach(System.out::println);
    }

    static void permute1(ArrayList<String> res, String digits, int index, StringBuilder sb) {

        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);


        List<Character> letters = map.getOrDefault(digit, List.of());

        if (letters.isEmpty()) {
            // Skip this digit but move forward in index
            permute1(res, digits, index + 1, sb);
            return;
        }

        for (char ch : letters) {
            sb.append(ch);
            permute1(res, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
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
