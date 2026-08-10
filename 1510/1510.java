class Solution {

    Boolean[] dp;

    public boolean winnerSquareGame(int n) {

        dp = new Boolean[n + 1];

        return solve(n);
    }

    private boolean solve(int n) {

        if (n == 0) {
            return false;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        for (int i = 1; i * i <= n; i++) {

            int square = i * i;

            if (!solve(n - square)) {
                dp[n] = true;
                return true;
            }
        }

        dp[n] = false;
        return false;
    }
}