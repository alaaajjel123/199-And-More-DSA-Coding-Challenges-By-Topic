public class Fibonacci {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n > 0) {
            dp[1] = 1;
        }
        int count = 1;
        while (count < n) {
            count++;
            dp[count] = dp[count - 1] + dp[count - 2];
        }
        return dp[n];
    }
}
