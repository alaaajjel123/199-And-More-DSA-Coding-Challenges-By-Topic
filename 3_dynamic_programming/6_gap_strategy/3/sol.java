public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longest = "";

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    longest = s.substring(i, j + 1);
                }
            }
        }

        return longest;
    }
}
