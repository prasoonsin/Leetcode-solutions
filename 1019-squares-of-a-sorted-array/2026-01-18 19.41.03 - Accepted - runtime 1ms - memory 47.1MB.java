class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1, idx = n - 1;

        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r]))
                res[idx--] = nums[l] * nums[l++];
            else
                res[idx--] = nums[r] * nums[r--];
        }
        return res;
    }
}
