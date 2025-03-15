public class KnapSack {
    public int knapSack(int W, int[] wt, int[] val, int n) {
        return helper(0, W, wt, val, n);
    }

    private int helper(int index, int rem_weight, int[] wt, int[] val, int n) {
        if (index >= n || rem_weight == 0) {
            return 0;
        }

        int exclude = helper(index + 1, rem_weight, wt, val, n);
        int include = 0;
        if (wt[index] <= rem_weight) {
            include = val[index] + helper(index + 1, rem_weight - wt[index], wt, val, n);
        }
        return Math.max(exclude, include);
    }
}