public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i <= n; i++) {
            int prevOne = cost[i - 1] + arr[i - 1];
            int prevTwo = cost[i - 2] + arr[i - 2];
            arr[i] = Math.min(prevOne, prevTwo);
        }

        return arr[n];
    }
}