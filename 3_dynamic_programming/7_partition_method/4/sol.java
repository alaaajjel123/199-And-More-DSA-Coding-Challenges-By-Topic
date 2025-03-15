import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (wordDict.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = dp[i][j] || (dp[i][k] && dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
