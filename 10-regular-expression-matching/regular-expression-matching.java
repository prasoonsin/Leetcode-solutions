class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Empty string vs patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                // Normal character or '.'
                if (currentP == '.' || currentP == currentS) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*'
                else if (currentP == '*') {

                    // Use '*' as zero occurrences
                    dp[i][j] = dp[i][j - 2];

                    // Use '*' for one or more occurrences
                    char previousP = p.charAt(j - 2);

                    if (previousP == '.' || previousP == currentS) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}