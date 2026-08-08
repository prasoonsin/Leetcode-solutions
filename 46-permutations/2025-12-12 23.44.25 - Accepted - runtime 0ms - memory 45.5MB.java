class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }
    private void backtrack(int[] nums, int start, List<List<Integer>> ans) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
             for (int x : nums) permutation.add(x);
            ans.add(permutation);
            return;

    }
    for (int i = start; i<nums.length; i++) {
        swap(nums, start, i);
        backtrack(nums, start + 1, ans);
        swap(nums, start, i);

    }
    }
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}