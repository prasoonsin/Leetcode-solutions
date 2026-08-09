import java.util.*;

class Solution {
    int[][] dp;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(piles, suffix, 0, 1);
    }

    private int solve(int[] piles, int[] suffix, int i, int M) {

        if (i >= piles.length) {
            return 0;
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

            int newM = Math.max(M, X);

            int current = suffix[i] - solve(piles, suffix, i + X, newM);

            best = Math.max(best, current);
        }

        dp[i][M] = best;

        return best;
    }
}