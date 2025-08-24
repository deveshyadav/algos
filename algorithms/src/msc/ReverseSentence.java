package msc;

public class ReverseSentence {
    public static void main(String[] args) {
        String str = "Learn to  give";
        System.out.println(reverse(str));
    }
    private static String reverse(String str){
        String[] a = str.trim().split("\\s+");
        StringBuilder r = new StringBuilder();
        for(int i=a.length-1;i>=0;i--){
            r.append(a[i]);
            if(i>0){
                r.append(" ");
            }
        }
        return r.toString();
    }
}
