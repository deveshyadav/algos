package freshworks;

public class _5LongestPalindromicSubstring {

    public static void main(String[] args) {
        String xx = "ababbbaa";
        String res = getLongestPalindrome(xx);
        System.out.println(res);
    }

    private static String getLongestPalindrome(String xx) {

        int start = 0;
        int end = 0;

        for(int i=0;i<xx.length();i++){
            int len1 =  expand(i,i, xx);
            int len2 = expand(i,i+1,xx);
            int len  =  Math.max(len1,len2);

            if(len>end-start+1){
                int half = (len-1)/2;
                start  = i-half;
                end = i + len/2;
            }
        }


        return xx.substring(start,end+1);
    }

    private static int expand(int l, int r, String s){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;r++;
        }
        return r-l-1;
    }
}
