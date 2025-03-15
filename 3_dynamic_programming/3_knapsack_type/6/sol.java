public class PartitionSubset {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        prev[0] = true;
        curr[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    curr[j] = prev[j - nums[i - 1]];
                } else {
                    curr[j] = false;
                }
                curr[j] = curr[j] || prev[j];
            }
            prev = curr.clone();
        }
        return curr[target];
    }
}
