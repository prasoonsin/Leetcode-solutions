class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int x : nums1) set1.add(x);
        for (int x : nums2)
            if (set1.contains(x)) res.add(x);

        int[] ans = new int[res.size()];
        int i = 0;
        for (int x : res) ans[i++] = x;
        return ans;
    }
}
