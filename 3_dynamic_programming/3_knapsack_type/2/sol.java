public class KnapSack {
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, W, wt, val, n, dp);
    }

    private int helper(int index, int remWeight, int[] wt, int[] val, int n, int[][] dp) {
        if (index >= n || remWeight == 0) {
            return 0;
        }
        if (dp[index][remWeight] != -1) {
            return dp[index][remWeight];
        }
        
        int exclude = helper(index + 1, remWeight, wt, val, n, dp);
        int include = 0;
        if (wt[index] <= remWeight) {
            include = val[index] + helper(index + 1, remWeight - wt[index], wt, val, n, dp);
        }
        
        dp[index][remWeight] = Math.max(exclude, include);
        return dp[index][remWeight];
    }
}
