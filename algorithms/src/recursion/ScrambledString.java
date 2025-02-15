package recursion;

public class ScrambledString {
    static String sss = "rgeat";
    public static void main(String[] args) {
        String s1 = "great";
        String s2= "rgeat";
        boolean result = scrambled(s1);
        System.out.println(" Scrambled:- "+result);
    }

    private static boolean scrambled(String s1) {
            if(sss.equals(s1)) return true;

            for(int i=1;i<s1.length();i++){
                split(s1,i);
            };
            return false;
    }

    private static void split(String s, int index){
        String s1 = s.substring(0, index);
        String s2 = s.substring(index);
        //String s3 = scrambled(s1) + scrambled(s2);
    }
}
