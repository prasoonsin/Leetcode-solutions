class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == n
        if (k == n) {
            int ans = -1;

            for (int x : nums) {
                ans = Math.max(ans, x);
            }

            return ans;
        }

        // Case 2: k == 1
        if (k == 1) {
            int ans = -1;

            for (int i = 0; i < n; i++) {

                boolean unique = true;

                for (int j = 0; j < n; j++) {
                    if (i != j && nums[i] == nums[j]) {
                        unique = false;
                        break;
                    }
                }

                if (unique) {
                    ans = Math.max(ans, nums[i]);
                }
            }

            return ans;
        }

        // Case 3: 1 < k < n

        int ans = -1;

        // Check first element
        boolean firstUnique = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[0]) {
                firstUnique = false;
                break;
            }
        }

        if (firstUnique) {
            ans = Math.max(ans, nums[0]);
        }

        // Check last element
        boolean lastUnique = true;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[n - 1]) {
                lastUnique = false;
                break;
            }
        }

        if (lastUnique) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}