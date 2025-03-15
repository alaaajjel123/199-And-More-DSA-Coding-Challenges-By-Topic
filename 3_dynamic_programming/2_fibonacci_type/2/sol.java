public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }
        return Math.min(helper(cost, array, 0), helper(cost, array, 1));
    }

    private int helper(int[] cost, int[] array, int index) {
        if (index >= cost.length) return 0;
        if (array[index] != -1) {
            return array[index];
        }
        int one = cost[index] + helper(cost, array, index + 1);
        int two = cost[index] + helper(cost, array, index + 2);
        array[index] = Math.min(one, two);
        return array[index];
    }
}
