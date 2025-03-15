public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(nums, 0, -1, dp);
    }

    private int helper(int[] nums, int curr, int prev, int[][] dp) {
        if (curr >= nums.length) {
            return 0;
        }
        
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int exclude = helper(nums, curr + 1, prev, dp);
        int include = 0;

        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + helper(nums, curr + 1, curr, dp);
        }

        dp[curr][prev + 1] = Math.max(include, exclude);
        return dp[curr][prev + 1];
    }
}
