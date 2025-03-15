public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        return helper(1, 2, n, 3);
    }

    private int helper(int first, int second, int n, int curr) {
        int next = first + second;
        if (curr == n) return next;
        return helper(second, next, n, curr + 1);
    }
}