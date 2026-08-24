class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Find total sum
        int sum = 0;
        for (int x : stones) {
            sum += x;
        }

        // dp represents the best score difference
        int dp = sum;

        // Calculate prefix sums from right to left
        for (int i = n - 2; i >= 1; i--) {

            sum -= stones[i + 1];

            dp = Math.max(dp, sum - dp);
        }

        return dp;
    }
}