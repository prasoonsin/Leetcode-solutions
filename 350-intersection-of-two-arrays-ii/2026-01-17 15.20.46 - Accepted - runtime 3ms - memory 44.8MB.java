import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of nums1
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Check nums2 against the map
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
