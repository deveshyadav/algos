package monthmarathon.leetcode.merge_intervals;

public class GardenFountainGreedy {
    public static void main(String[] args) {
        int[] arr = {3,4,1,1,0,0};
        int n = arr.length - 1;

        int result = minFountainsToActivate(n, arr);
        System.out.println(result);  // Output: 2
    }

    public static int minFountainsToActivate(int n, int[] arr) {
        int[] rightMost = new int[n + 1];

        // Step 1: Build rightMost[i] = farthest right index covered starting from i
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - arr[i]);
            int right = Math.min(n, i + arr[i]);
            rightMost[left] = Math.max(rightMost[left], right);
        }

        // Step 2: Greedy expand coverage
        int fountains = 0;
        int currEnd = 0;
        int nextEnd = 0;

        for (int i = 0; i <= n; i++) {
            nextEnd = Math.max(nextEnd, rightMost[i]);

            if (i == currEnd) {
                if(i==n) return fountains;
                fountains++;
                currEnd = nextEnd;

                // If we can't go further
                if (currEnd == i && i != n) return -1;
            }
        }

        return fountains;
    }
}
