public class MatrixMultiplication {

    public int matrixMultiplication(int N, int[] arr) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }
        return findCost(1, N - 1, arr, dp);
    }

    private int findCost(int i, int j, int[] arr, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int cost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int currCost = findCost(i, k, arr, dp) + findCost(k + 1, j, arr, dp) + arr[i - 1] * arr[k] * arr[j];
            cost = Math.min(cost, currCost);
        }

        dp[i][j] = cost;
        return dp[i][j];
    }
}
