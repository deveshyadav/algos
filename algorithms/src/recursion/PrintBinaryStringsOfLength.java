package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryStringsOfLength {
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryStringsHelper(n, "", result);
        return result;
    }

    private static void generateBinaryStringsHelper(int n, String currentString, List<String> result) {
        if (n == 0) {
            result.add(currentString);
            return;
        }

        generateBinaryStringsHelper(n - 1, currentString + "0", result);
        generateBinaryStringsHelper(n - 1, currentString + "1", result);
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaryStrings = generateBinaryStrings(n);
        System.out.println(binaryStrings);
    }
}