public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(text1, text2, 0, 0, dp);
    }

    private int helper(String text1, String text2, int index1, int index2, int[][] dp) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            dp[index1][index2] = 1 + helper(text1, text2, index1 + 1, index2 + 1, dp);
            return dp[index1][index2];
        }

        dp[index1][index2] = Math.max(helper(text1, text2, index1 + 1, index2, dp), 
                                      helper(text1, text2, index1, index2 + 1, dp));

        return dp[index1][index2];
    }
}
