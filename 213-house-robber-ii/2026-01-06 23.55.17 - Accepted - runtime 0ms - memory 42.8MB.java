class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: rob from 0 to n-2
        int money1 = robLinear(nums, 0, n - 2);

        // Case 2: rob from 1 to n-1
        int money2 = robLinear(nums, 1, n - 1);

        return Math.max(money1, money2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int take = prev2 + nums[i];
            int skip = prev1;
            int curr = Math.max(take, skip);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
