public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int curr, int prev) {
        if (curr >= nums.length) {
            return 0;
        }

        int exclude = helper(nums, curr + 1, prev);
        int include = 0;

        if (prev == -1 || nums[curr] > nums[prev]) {
            include = 1 + helper(nums, curr + 1, curr);
        }

        return Math.max(include, exclude);
    }
}
