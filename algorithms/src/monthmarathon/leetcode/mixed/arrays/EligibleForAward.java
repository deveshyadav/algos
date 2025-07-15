package monthmarathon.leetcode.mixed.arrays;

public class EligibleForAward {

    public static void main(String[] args) {
        String att = "LALL";
        boolean res = getEligibility(att);
        System.out.println(res);
    }

    private static boolean getEligibility(String att) {

        int ab = 0;
        int consL = 0;
        char[] arr = att.toCharArray();
        int maxCons = 0;
        for(int i=0;i<att.length();i++){

            if(arr[i] == 'A') {
                ab ++;
                consL=0;
                continue;
            }
            if(arr[i] == 'L'){
                consL++;
                maxCons = Math.max(consL,maxCons);
                continue;
            }
            consL = 0;
        }
        return ab < 2 && maxCons < 3;

    }
}