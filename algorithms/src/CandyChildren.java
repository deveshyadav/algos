import java.util.Arrays;

public class CandyChildren {
    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,2};
        int[] candy = giveCandy(ratings);
        System.out.println(Arrays.toString(ratings));
        System.out.println(Arrays.toString(candy));
    }

    private static int[] giveCandy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int n = ratings.length;
        Arrays.fill(candy, 1);

        for(int i=0; i<n-1; i++){
            System.out.println("ratings[i]: "+ratings[i] + " ratings[i+1]: " + ratings[i+1]);
            if(ratings[i] < ratings[i+1]){
                candy[i+1]++;
            }
        }
        for(int i=n-1; i>0; i--){
            System.out.println("ratings[i]: "+ratings[i] + " ratings[i+1]: " + ratings[i-1]);
            if(ratings[i] < ratings[i-1]){
                candy[i]++;
            }
        }
        return candy;

    }
}
