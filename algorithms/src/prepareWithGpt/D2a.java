package prepareWithGpt;

import java.util.Arrays;

public class D2a {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,5};
        int mn = missing(a);
        System.out.println(mn + " is missing.");
    }

    private static int missing(int[] a) {
        int n = a.length;
        int esum = (n*(n+1))/2;
        int sum = Arrays.stream(a).sum();

        return esum-sum;
    }
}
