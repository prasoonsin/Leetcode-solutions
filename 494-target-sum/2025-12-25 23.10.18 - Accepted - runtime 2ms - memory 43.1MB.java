class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int x : nums) sum += x;

         if (Math.abs(target) > sum || (sum + target) % 2 != 0) 
            return 0;

        int newTarget = (sum + target) / 2;

       
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int s = newTarget; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }

        return dp[newTarget];
    }
}
