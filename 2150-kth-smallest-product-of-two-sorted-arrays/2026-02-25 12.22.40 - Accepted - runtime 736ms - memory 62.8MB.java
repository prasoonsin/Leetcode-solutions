class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long cnt = count(nums1, nums2, mid);
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public long count(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            if (a > 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) a * nums2[mid] <= target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                count += l;
            } else if (a < 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) a * nums2[mid] <= target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
               count += nums2.length - l;
            } else { 
                if (target >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}