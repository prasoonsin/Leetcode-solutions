class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Check sign
        boolean negative = (dividend < 0) != (divisor < 0);

        // Convert to positive long values
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double divisor while possible
            while (a >= temp + temp) {
                temp += temp;
                multiple += multiple;
            }

            // Subtract the largest possible multiple
            a -= temp;
            result += multiple;
        }

        // Apply sign
        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}