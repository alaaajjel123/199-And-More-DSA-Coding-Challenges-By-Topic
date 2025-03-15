public class KnapSack {
    public int knapSack(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int exclude = dp[i - 1][j];
                    int include = 0;
                    if (wt[i - 1] <= j) {
                        include = val[i - 1] + dp[i][j - wt[i - 1]];
                    }
                    dp[i][j] = Math.max(exclude, include);
                }
            }
        }
        return dp[N][W];
    }
}
