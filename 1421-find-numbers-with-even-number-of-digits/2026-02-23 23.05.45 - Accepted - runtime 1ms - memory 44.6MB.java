class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int digits = 0;

            if (num < 0) {
                num = -num;
            }

            if (num == 0) {
                digits = 1;
            } else {
                while (num > 0) {
                    digits++;
                    num /= 10;
                }
            }

            if (digits % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}