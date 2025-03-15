public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    private int helper(int[] cost, int index) {
        if (index >= cost.length) return 0;
        int one = cost[index] + helper(cost, index + 1);
        int two = cost[index] + helper(cost, index + 2);
        return Math.min(one, two);
    }
}