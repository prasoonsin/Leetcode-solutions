class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int jump = 1; jump <= 3; jump++) {

                if (i >= jump) {
                    int currentCost = dp[i - jump]
                            + costs[i - 1]
                            + jump * jump;

                    dp[i] = Math.min(dp[i], currentCost);
                }
            }
        }

        return dp[n];
    }
}