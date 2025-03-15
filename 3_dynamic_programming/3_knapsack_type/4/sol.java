public class KnapSack {
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int exclude = prev[j];
                int include = 0;
                if (wt[i - 1] <= j) {
                    include = val[i - 1] + prev[j - wt[i - 1]];
                }
                curr[j] = Math.max(exclude, include);
            }
            prev = curr.clone();
        }
        return curr[W];
    }
}
