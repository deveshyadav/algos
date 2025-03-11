package recursion;

import java.util.ArrayList;
import java.util.List;

public class WildcardSubstitutions {

    public static void generateStrings(String s, int index, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        char c = s.charAt(index);
        if (c == '?') {
            current.append('0');
            generateStrings(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);

            current.append('1');
            generateStrings(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        } else {
            current.append(c);
            generateStrings(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "1?0?1";
        List<String> result = new ArrayList<>();
        generateStrings(input, 0, new StringBuilder(), result);

        System.out.println("Possible strings are:");
        for (String str : result) {
            System.out.println(str);
        }

        System.out.println("Total number of strings: " + result.size());
    }
}
