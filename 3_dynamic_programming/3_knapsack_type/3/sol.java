public class KnapSack {
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int exclude = dp[i - 1][j];
                int include = 0;
                if (wt[i - 1] <= j) {
                    include = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }
                dp[i][j] = Math.max(exclude, include);
            }
        }
        return dp[n][W];
    }
}
